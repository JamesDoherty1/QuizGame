package EPICGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;

public class ChatGPTWidget {
    JFrame frame = new JFrame("ChatGPT Widget");
    JLabel instructionLabel = new JLabel("Enter your search query:");
    JTextField inputField = new JTextField(20);
    JButton submitButton = new JButton("Submit");
    JTextArea responseArea = new JTextArea(10, 60);
    JButton returnButton = new JButton("Return");
    ImageIcon backgroundImage = new ImageIcon("images/ChatGPTBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    ChatGPTWidget() {
        frame.add(backgroundLabel);
        frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        instructionLabel.setBounds(centerX - 500, centerY - 400, 400, 40);
        instructionLabel.setForeground(new Color(0, 255, 255));
        instructionLabel.setFont(new Font("Orbitron", Font.BOLD, 25));

        submitButton.setBounds(centerX + 180, centerY - 400, 150, 50);
        submitButton.setBackground(new Color(0, 255, 255));
        submitButton.setFont(new Font("Black Ops One", Font.PLAIN, 30));

        responseArea.setWrapStyleWord(true);
        responseArea.setLineWrap(true);
        responseArea.setEditable(false);
        responseArea.setBounds(centerX - 250, centerY - 320, 500, 550);
        responseArea.setBackground(new Color(128, 0, 255));
        responseArea.setFont(new Font("Black Ops One", Font.PLAIN, 15));

        inputField.setBounds(centerX - 145, centerY - 400, 300, 50);
        inputField.setBackground(new Color(0, 255, 255));
        inputField.setFont(new Font("Black Ops One", Font.PLAIN, 15));

        returnButton.setBounds(centerX - 100, centerY + 250, 200, 50);
        returnButton.setBackground(new Color(0, 255, 255));
        returnButton.setFont(new Font("Black Ops One", Font.PLAIN, 30));

        frame.add(instructionLabel);
        frame.add(inputField);
        frame.add(submitButton);
        frame.add(responseArea);
        frame.add(returnButton);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = inputField.getText();

                if (!query.isEmpty()) {
                    String response = ChatGPTWidget.chatGPT(query);
                    responseArea.setText(response);
                } else {
                    responseArea.setText("Please enter a search query.");
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnButton) {
                    new WelcomePage("again");
                    frame.dispose();
                }
            }
        });
    }

    public static String chatGPT (String prompt){
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";
        //Creating variables for the url, api and model

        try {//try and catch used incase mistakes happen

            URL object = new URL(url); //Creates a URL from url
            HttpURLConnection connection = (HttpURLConnection) object.openConnection(); //Established a connection to the URL

            connection.setRequestMethod("POST"); //Specifies that I want to send (post) data to the server
            connection.setRequestProperty("Authorization", "Bearer " + apiKey); //The 'Authorization' Header is set with the API key
            connection.setRequestProperty("Content-Type", "application/json");

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            //A JSON-formatted string is created to send info to the server
            connection.setDoOutput(true); //The connection should allow output.
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body); //It will write the body content to send it to the server.
            writer.flush(); //Any buffered data is sent immediately
            writer.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //A BufferedReader is created to read the response from the server.
            StringBuffer response = new StringBuffer(); //Store response as a mutable String

            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            } // While there are still lined to read, add the lines to response

            br.close();
            return extractMessageFromJSONResponse(response.toString());
        } catch (IOException var11) {
            throw new RuntimeException(var11);
            //Incase an IOException happens
        }
    }

    public static String extractMessageFromJSONResponse (String response){
        int start = response.indexOf("content") + 11;
        int end = response.indexOf("\"", start);
        return response.substring(start, end);
    } //Parses a JSON response string and specifically extract the value associated with the "content" field.



    public static void main(String[] args) {
        new ChatGPTWidget();
    }
}