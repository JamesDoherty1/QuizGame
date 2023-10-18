package EPICGame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGPTWidget {
    public ChatGPTWidget() {
    }

    public static String chatGPT(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";

        try {
            URL object = new URL(url); //Creates a URL from url
            HttpURLConnection connection = (HttpURLConnection)object.openConnection(); //Established a connection to the URL

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
            while((line = br.readLine()) != null) {
                response.append(line);
            } // While there are still lined to read, add the lines to response

            br.close();
            return extractMessageFromJSONResponse(response.toString());
        } catch (IOException var11) {
            throw new RuntimeException(var11);
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content") + 11;
        int end = response.indexOf("\"", start);
        return response.substring(start, end);
    } //Parses a JSON response string and specifically extract the value associated with the "content" field.

    public static void main (String[] args) {
        JFrame frame = new JFrame("ChatGPT Widget");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel instructionLabel = new JLabel("Enter your search query:");
        panel.add(instructionLabel);

        final JTextField inputField = new JTextField(20);
        panel.add(inputField);

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        final JTextArea responseArea = new JTextArea(10, 60);
        responseArea.setWrapStyleWord(true);
        responseArea.setLineWrap(true);
        responseArea.setEditable(false);
        panel.add(new JScrollPane(responseArea));

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(660, 600, 130, 35);
        frame.add(returnButton);

        frame.add(panel);
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

                if (e.getSource() == returnButton){
                    new WelcomePage("again");
                    frame.dispose();
                }
            }
        });
    }
}

