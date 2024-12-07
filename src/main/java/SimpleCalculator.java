import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SimpleCalculator extends Application {

    private TextField input;

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        input = new TextField();
        input.setEditable(false);
        Button zerobutton = new Button("0");
        Button onebutton = new Button("1");
        Button twobutton = new Button("2");
        Button threebutton = new Button("3");
        Button fourbutton = new Button("4");
        Button fivebutton = new Button("5");
        Button sixbutton = new Button("6");
        Button sevenbutton = new Button("7");
        Button eightbutton = new Button("8");
        Button ninebutton = new Button("9");

        Button multbutton = new Button("*");
        Button dividebutton = new Button("/");
        Button addbutton = new Button("+");
        Button minusbutton = new Button("-");

        Button equalsbutton = new Button("=");
        Button clearbutton = new Button("C");

        setButtonAction(zerobutton, "0");
        setButtonAction(onebutton, "1");
        setButtonAction(twobutton, "2");
        setButtonAction(threebutton, "3");
        setButtonAction(fourbutton, "4");
        setButtonAction(fivebutton, "5");
        setButtonAction(sixbutton, "6");
        setButtonAction(sevenbutton, "7");
        setButtonAction(eightbutton, "8");
        setButtonAction(ninebutton, "9");

        setOperatorAction(multbutton, "*");
        setOperatorAction(dividebutton, "/");
        setOperatorAction(addbutton, "+");
        setOperatorAction(minusbutton, "-");

        equalsbutton.setOnAction(e -> calculate());
        clearbutton.setOnAction(e -> clearDisplay());

        HBox box1 = new HBox(10, sevenbutton, eightbutton, ninebutton, dividebutton);
        HBox box2 = new HBox(10, fourbutton, fivebutton, sixbutton, multbutton);
        HBox box3 = new HBox(10, onebutton, twobutton, threebutton, minusbutton);
        HBox box4 = new HBox(10, zerobutton, equalsbutton, clearbutton, addbutton);
        VBox hbox = new VBox(10, input , box1, box2, box3, box4);

        Scene scene = new Scene(hbox, 300, 250);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void setButtonAction(Button button, String value) {
        button.setOnAction(e -> input.appendText(value));
    }

    private void setOperatorAction(Button button, String operator) {
        button.setOnAction(e -> input.appendText(" " + operator + " "));
    }

    private void clearDisplay() {
        input.clear();
    }

    private void calculate() {
        try {
            String expression = input.getText();
            String[] parts = expression.split(" ");
            if (parts.length == 3) {
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[2]);
                String operator = parts[1];

                int result = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            input.setText("Error: Division by zero");
                            return;
                        }
                        break;
                }
                input.setText(String.valueOf(result));
            }
        } catch (Exception e) {
            input.setText("Error");
        }
    }
}
