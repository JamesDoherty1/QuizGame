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
            URL object = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)object.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();

            String line;
            while((line = br.readLine()) != null) {
                response.append(line);
            }

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
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame("ChatGPT Widget");
        frame.setDefaultCloseOperation(3);
        frame.setExtendedState(6);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel instructionLabel = new JLabel("Enter your search query:");
        panel.add(instructionLabel);

        final JTextField inputField = new JTextField(20);
        panel.add(inputField);

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        final JTextArea responseArea = new JTextArea(5, 30);
        responseArea.setWrapStyleWord(true);
        responseArea.setLineWrap(true);
        responseArea.setEditable(false);
        panel.add(new JScrollPane(responseArea));

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(660, 600, 130, 35);
        frame.add(returnButton);

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


        frame.add(panel);
        frame.setVisible(true);


    }
}

