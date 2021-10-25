package Main;

import javax.script.ScriptException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application{
	VBox vBox = new VBox();
	
	Pane pane = new Pane();
	TextArea ta = new TextArea();

	HBox hBox = new HBox();
	Button btClear = new Button("CLEAR");
	Button btExit = new Button("EXIT");
	
	HBox hBox0 = new HBox();
	GridPane gridPane = new GridPane();
	Button bt0 = new Button("0");
	Button bt1 = new Button("1");
	Button bt2 = new Button("2");
	Button bt3 = new Button("3");
	Button bt4 = new Button("4");
	Button bt5 = new Button("5");
	Button bt6 = new Button("6");
	Button bt7 = new Button("7");
	Button bt8 = new Button("8");
	Button bt9 = new Button("9");
	Button btAdd = new Button("+");
	Button btSubtract = new Button("-");
	Button btMultiply = new Button("*");
	Button btDivide = new Button("/");
	Button btDot = new Button(".");
	Button btPow = new Button("pow");
	Button btMean = new Button("mean");
	Button btMod  = new Button("mod");
	Button btSqrt = new Button("sqrt");
	Button btAbs = new Button("abs");
	
	VBox vBox0 = new VBox();
	Button btLBracket = new Button("(");
	Button btRBracket = new Button(")");
	Button btComma = new Button(",");
	Button btEqual = new Button("=");
	
	@Override
	public void start(Stage primaryStage) {
		
		
		btClear.setOnAction(e -> ta.clear());
		btExit.setOnAction(e -> primaryStage.close());
		bt1.setOnAction(e -> ta.appendText("1"));
		bt2.setOnAction(e -> ta.appendText("2"));
		bt3.setOnAction(e -> ta.appendText("3"));
		bt4.setOnAction(e -> ta.appendText("4"));
		bt5.setOnAction(e -> ta.appendText("5"));
		bt6.setOnAction(e -> ta.appendText("6"));
		bt7.setOnAction(e -> ta.appendText("7"));
		bt8.setOnAction(e -> ta.appendText("8"));
		bt9.setOnAction(e -> ta.appendText("9"));
		bt0.setOnAction(e -> ta.appendText("0"));
		btAdd.setOnAction(e -> ta.appendText("+"));
		btSubtract.setOnAction(e -> ta.appendText("-"));
		btMultiply.setOnAction(e -> ta.appendText("*"));
		btDivide.setOnAction(e -> ta.appendText("/"));
		btDot.setOnAction(e -> ta.appendText("."));
		btPow.setOnAction(e -> ta.appendText("pow"));
		btMean.setOnAction(e -> ta.appendText("mean"));
		btMod.setOnAction(e -> ta.appendText("mod"));
		btSqrt.setOnAction(e -> ta.appendText("sqrt"));
		btAbs.setOnAction(e -> ta.appendText("abs"));
		btLBracket.setOnAction(e -> ta.appendText("("));
		btRBracket.setOnAction(e -> ta.appendText(")"));
		btComma.setOnAction(e -> ta.appendText(","));
		btEqual.setOnAction(e -> calculate());
		
		ta.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				calculate();
			}
		});
		
		VBox vBox0 = getPane();
		
		Scene primaryScene = new Scene(vBox0, 500, 400);
		primaryStage.setTitle("王岩立课程设计——计算器");
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public VBox getPane() {
		ta.setPrefSize(500, 50);
		ta.setStyle("-fx-font-size: 18");
		pane.getChildren().add(ta);
		
		btClear.setPrefSize(250, 50);
		btExit.setPrefSize(250, 50);
		btClear.setStyle("-fx-border-color: #000000; -fx-background-color: orange; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btExit.setStyle("-fx-border-color: #000000; -fx-background-color: #d71345; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		hBox.getChildren().addAll(btClear, btExit);
		
		bt1.setPrefSize(100, 60);
		bt2.setPrefSize(100, 60);
		bt3.setPrefSize(100, 60);
		bt4.setPrefSize(100, 60);
		bt5.setPrefSize(100, 60);
		bt6.setPrefSize(100, 60);
		bt7.setPrefSize(100, 60);
		bt8.setPrefSize(100, 60);
		bt9.setPrefSize(100, 60);
		bt0.setPrefSize(100, 60);
		btAdd.setPrefSize(100, 60);
		btSubtract.setPrefSize(100, 60);
		btMultiply.setPrefSize(100, 60);
		btDivide.setPrefSize(100, 60);
		btDot.setPrefSize(100, 60);
		btPow.setPrefSize(100, 60);
		btMean.setPrefSize(100, 60);
		btMod.setPrefSize(100, 60);
		btSqrt.setPrefSize(100, 60);
		btAbs.setPrefSize(100, 60);
		
		bt1.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt2.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt3.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt4.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt5.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt6.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt7.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt8.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt9.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		bt0.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btAdd.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btSubtract.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btMultiply.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btDivide.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btDot.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btPow.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btMean.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btMod.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btSqrt.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btAbs.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		
		gridPane.add(bt1, 0, 0);
		gridPane.add(bt2, 1, 0);
		gridPane.add(bt3, 2, 0);
		gridPane.add(btAdd, 3, 0);
		gridPane.add(bt4, 0, 1);
		gridPane.add(bt5, 1, 1);
		gridPane.add(bt6, 2, 1);
		gridPane.add(btSubtract, 3, 1);
		gridPane.add(bt7, 0, 2);
		gridPane.add(bt8, 1, 2);
		gridPane.add(bt9, 2, 2);
		gridPane.add(btMultiply, 3, 2);
		gridPane.add(bt0, 0, 3);
		gridPane.add(btDot, 1, 3);
		gridPane.add(btPow, 2, 3);
		gridPane.add(btDivide, 3, 3);
		gridPane.add(btMean, 0, 4);
		gridPane.add(btMod, 1, 4);
		gridPane.add(btSqrt, 2, 4);
		gridPane.add(btAbs, 3, 4);
		
		btLBracket.setPrefSize(100, 60);
		btRBracket.setPrefSize(100, 60);
		btComma.setPrefSize(100, 60);
		btEqual.setPrefSize(100, 120);
		
		btLBracket.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btRBracket.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btComma.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
		btEqual.setStyle("-fx-border-color: #000000; -fx-background-color: #ad8b3d; -fx-font-size: 30px; -fx-text-fill: white; -fx-font-weight:bold");
		vBox0.getChildren().addAll(btLBracket, btRBracket, btComma, btEqual);
		
		hBox0.getChildren().addAll(gridPane, vBox0);
		vBox.getChildren().addAll(pane, hBox, hBox0);
		return vBox;
	}
	
	public void calculate() {
		String expression = ta.getText().toString();
		
		for (int i=0; i<expression.length(); i++) {
			
			if (expression.charAt(i) == 'm' && expression.charAt(i+1) == 'e' && expression.charAt(i+2) == 'a') {
				for (int j=i+5; j<expression.length(); j++) {
					if (expression.charAt(j) == ')') {
						String subStr = expression.substring(i+5, j);
						String[] strList = subStr.split(",");
						double result = 0;
						for (int m=0; m<strList.length; m++) {
							result += Double.parseDouble(strList[m]);
						}
						result = result / strList.length;
						expression = expression.replace(expression.substring(i, j+1), result+"");
						break;
					}
					
				}
			}
			else if (expression.charAt(i) == 'm' && expression.charAt(i+1) == 'o' && expression.charAt(i+2) == 'd') {
				for (int j=i+4; j<expression.length(); j++) {
					if (expression.charAt(j) == ')') {
						String subStr = expression.substring(i+4, j);
						String[] strList = subStr.split(",");
						double result = 0;
						result = Math.floorMod(Integer.parseInt(strList[0]), Integer.parseInt(strList[1]));
						expression = expression.replace(expression.substring(i, j+1), result+"");
						break;
					}
				}
			}
			else if (expression.charAt(i) == 's' && expression.charAt(i+1) == 'q' && expression.charAt(i+2) == 'r') {
				for (int j=i+5; j<expression.length(); j++) {
					if (expression.charAt(j) == ')') {
						String subStr = expression.substring(i+5, j);
						String str = subStr;
						double result = 0;
						result = Math.sqrt(Double.parseDouble(str));
						expression = expression.replace(expression.substring(i, j+1), result+"");
						break;
					}
				}
			}
			else if (expression.charAt(i) == 'a' && expression.charAt(i+1) == 'b' && expression.charAt(i+2) == 's') {
				for (int j=i+4; j<expression.length(); j++) {
					if (expression.charAt(j) == ')') {
						String subStr = expression.substring(i+4, j);
						String str = subStr;
						double result = 0;
						result = Math.abs(Double.parseDouble(str));
						expression = expression.replace(expression.substring(i, j+1), result+"");
						break;
					}
				}
			}
			else if (expression.charAt(i) == 'p' && expression.charAt(i+1) == 'o' && expression.charAt(i+2) == 'w') {
				for (int j=i+4; j<expression.length(); j++) {
					if (expression.charAt(j) == ')') {
						String subStr = expression.substring(i+4, j);
						String[] strList = subStr.split(",");
						double result = 0;
						result = Math.pow(Double.parseDouble(strList[0]), Double.parseDouble(strList[1]));
						expression = expression.replace(expression.substring(i, j+1), result+"");
						break;
					}
				}
			}
		}
		
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");

		try {
            expression = String.valueOf(scriptEngine.eval(expression));
            
        } catch (ScriptException e) {
            e.printStackTrace();
        }
		
		expression = Math.round(100000 * Double.parseDouble(expression)) / 100000.0 + "";
		
		ta.appendText("\n=" + expression);
	}
	
	
}
