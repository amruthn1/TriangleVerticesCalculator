import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JLabel title = new JLabel();
        JLabel hint = new JLabel();
        JButton submit = new JButton("Calculate");
        JLabel result = new JLabel();
        JTextField vertice1, vertice2, vertice3;
        title.setText("Find The Area Of A Triangle With 3 Vertices");
        hint.setText("Enter the vertices in this format: (x, y)");
        result.setText("Result:");
        vertice1 = new JTextField("Type your first vertice here");
        vertice2 = new JTextField("Type your second vertice here");
        vertice3 = new JTextField("Type your third vertice here");
        vertice1.setBounds(240, 100, 200, 30);
        vertice2.setBounds(240, 70, 200, 30);
        vertice3.setBounds(240, 40, 200, 30);
        submit.setBounds(280, 180, 100, 30);
        result.setBounds(280, 210, 200, 30);
        title.setBounds(220, 10, 300, 30);
        hint.setBounds(220, 130, 300, 30);
        jFrame.add(title);
        jFrame.add(hint);
        jFrame.add(submit);
        jFrame.add(vertice1);
        jFrame.add(vertice2);
        jFrame.add(vertice3);
        jFrame.add(result);
        jFrame.setSize(700, 400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coordinate1 = vertice1.getText();
                String coordinate2 = vertice2.getText();
                String coordinate3 = vertice3.getText();
                if (coordinate1.isEmpty() || coordinate2.isEmpty() || coordinate3.isEmpty()) {
                    result.setBounds(160, 210, 400, 30);
                    result.setText("There are no values provided for one or more of the text fields.");
                } else {
                    if (!coordinate1.contains(",") || !coordinate2.contains(",") || !coordinate3.contains(",")) {
                        result.setBounds(160, 210, 400, 30);
                        result.setText("There are no commas in one or more of the coordinates provided.");
                    } else {
                        if(coordinate1.matches(".*[^a-z].*") || coordinate2.matches(".*[^a-z].*") || coordinate3.matches(".*[^a-z].*")){
                            result.setBounds(200, 210, 400, 30);
                            result.setText("There can't be any letters in the textfields.");
                        } else {
                            result.setBounds(280, 210, 100, 30);
                            Double ax = Double.parseDouble((coordinate1.split(",")[0]).replace("(", ""));
                            Double ay = Double.parseDouble((coordinate1.split(",")[1]).replace(")", ""));
                            Double bx = Double.parseDouble((coordinate2.split(",")[0]).replace("(", ""));
                            Double by = Double.parseDouble((coordinate2.split(",")[1]).replace(")", ""));
                            Double cx = Double.parseDouble((coordinate3.split(",")[0]).replace("(", ""));
                            Double cy = Double.parseDouble((coordinate3.split(",")[1]).replace(")", ""));
                            Double output = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by))/2;
                            System.out.println(output);
                            result.setText("Result: " + Double.toString(output));
                        }
                    }
                }
            }
        });
    }
}
