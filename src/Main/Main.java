package Main;

import java.text.ParseException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		
		Image image = new Image("file:src/src/SCUT.png");
		ImageView iv = new ImageView(image);
		iv.setFitHeight(200);
		iv.setFitWidth(200);
		
		Pane pane = new Pane();
		pane.setPrefSize(200, 30);
		
		Button btCalc = new Button("计算器");
		Button btCalen = new Button("日历");
		Button btDraw = new Button("绘制图形");
		Button btExit = new Button("EXIT");
		
		btCalc.setPrefSize(200, 50);
		btCalen.setPrefSize(200, 50);
		btDraw.setPrefSize(200, 50);	
		btExit.setPrefSize(100, 50);
		btCalc.setStyle("-fx-background-color: #4e72b8; -fx-border-color: black; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold");
		btCalen.setStyle("-fx-background-color: #003a6c; -fx-border-color: black; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold");
		btDraw.setStyle("-fx-background-color: #2a5caa; -fx-border-color: black; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold");
		btExit.setStyle("-fx-background-color: #d71345; -fx-border-color: black; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold");
		
		Pane pane1 = new Pane();
		pane1.setPrefSize(200, 20);
		Pane pane2 = new Pane();
		pane2.setPrefSize(200, 20);
		Pane pane3 = new Pane();
		pane3.setPrefSize(200, 20);
		
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(iv, pane, btCalc, pane1, btCalen, pane2, btDraw, pane3, btExit);
		vBox.setAlignment(Pos.CENTER);
		
		btCalc.setOnAction(e -> new Calculator().start(new Stage()));
		btCalen.setOnAction(e -> {
			try {
				new Calendar().start(new Stage());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btDraw.setOnAction(e -> new Drawing().start(new Stage()));
		btExit.setOnAction(e -> primaryStage.close());
		
		Scene scene = new Scene(vBox, 500, 500);

		primaryStage.setTitle("王岩立课程设计——启动菜单");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
