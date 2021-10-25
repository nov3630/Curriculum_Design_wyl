package Main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Drawing extends Application{
	//������ײ����
	VBox vBox = new VBox();
	//�����϶�ѡ������������
	GridPane gridPane0 = new GridPane();
	//�����м���ʾͼ����������
	Pane pane = new Pane();
	//�����¶�ѡ������������
	GridPane gridPane1 = new GridPane();
	//�����϶�ѡ����
	Button bt0 = new Button("ֱ��");
	ComboBox<String> cbo1 = new ComboBox<>();	
	ObservableList<String> items1 = FXCollections.observableArrayList(new String[]{"������Բ", "ʵ����Բ"});
	ComboBox<String> cbo2 = new ComboBox<>();
	ObservableList<String> items2 = FXCollections.observableArrayList(new String[]{"���ľ���", "ʵ�ľ���"});
	Button bt3 = new Button("�����");
	//�����¶�ѡ����		
	HBox hBox0 = new HBox();
	Pane pane0 = new Pane();
	Button bt00 = new Button("ֱ��");
	Button bt10 = new Button("������Բ");
	Button bt11 = new Button("ʵ����Բ");
	Button bt20 = new Button("���ľ���");
	Button bt21 = new Button("ʵ�ľ���");
	Button bt30 = new Button("�����");
	//�����ڷ���պ��˳���ť��VBox	
	VBox vBox0 = new VBox();
	Button btClear = new Button("���");
	Button btExit = new Button("�˳�");
	
	@Override
	public void start(Stage primaryStage) {
		
		btExit.setOnAction(e -> {
			primaryStage.close();
		});
		
		VBox pane0 = getPane();
		
		
		Scene primaryScene = new Scene(pane0, 500, 400);
		primaryStage.setTitle("�������γ���ơ�������ͼ��");
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public VBox getPane() {
		//�����м����Ĵ�С
		pane.setPrefSize(500, 300);
		
		//�����϶�ѡ����������
		bt0.setPrefSize(90, 40);

		cbo1.getItems().addAll("������Բ", "ʵ����Բ");		
		cbo1.setValue("��Բ");
		cbo1.setPrefSize(90, 40);

		cbo2.getItems().addAll("���ľ���", "ʵ�ľ���");		
		cbo2.setValue("����");
		cbo2.setPrefSize(90, 40);

		bt3.setPrefSize(90, 40);
		
		bt0.setStyle("-fx-border-color: #000000; -fx-background-color: #fedcbd; -fx-font-size: 13px; -fx-font-weight:bold");
		cbo1.setStyle("-fx-border-color: #000000; -fx-background-color: #fedcbd; -fx-font-size: 13px; -fx-font-weight:bold");
		cbo2.setStyle("-fx-border-color: #000000; -fx-background-color: #fedcbd; -fx-font-size: 13px; -fx-font-weight:bold");
		bt3.setStyle("-fx-border-color: #000000; -fx-background-color: #fedcbd; -fx-font-size: 13px; -fx-font-weight:bold");
		
		
		gridPane0.add(bt0, 0, 0);
		gridPane0.add(cbo1, 1, 0);
		gridPane0.add(cbo2, 2, 0);
		gridPane0.add(bt3, 3, 0);
		
		//�����¶�ѡ����������
		bt00.setPrefSize(90, 40);
		bt10.setPrefSize(90, 40);
		bt11.setPrefSize(90, 40);
		bt20.setPrefSize(90, 40);
		bt21.setPrefSize(90, 40);
		bt30.setPrefSize(90, 40);
		
		bt00.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
		bt10.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
		bt11.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
		bt20.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
		bt21.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
		bt30.setStyle("-fx-border-color: #000000; -fx-background-color: #7fb80e; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
		
		btClear.setStyle("-fx-border-color: #000000; -fx-background-color: orange; -fx-font-size: 15px; -fx-text-fill: white");
		btExit.setStyle("-fx-border-color: #000000; -fx-background-color: #d71345; -fx-font-size: 15px; -fx-text-fill: white");
		

		gridPane1.add(bt00, 0, 0);
		gridPane1.add(bt10, 1, 0);
		gridPane1.add(bt11, 1, 1);
		gridPane1.add(bt20, 2, 0);
		gridPane1.add(bt21, 2, 1);
		gridPane1.add(bt30, 3, 0);
		
		pane0.setPrefSize(20, 30);
		
		
		vBox0.getChildren().addAll(btClear, btExit);
		
		hBox0.getChildren().addAll(gridPane1, pane0, vBox0);
		
		vBox.getChildren().addAll(gridPane0, pane, hBox0);
		
		bt0.setOnAction(e -> createLine());
		cbo1.setOnAction(e -> createEllipse(items1.indexOf(cbo1.getValue())));
		cbo2.setOnAction(e -> createRectangle(items2.indexOf(cbo2.getValue())));
		bt3.setOnAction(e -> createPolygon());
		
		bt00.setOnAction(e -> createLine());
		bt10.setOnAction(e -> createEllipse(0));
		bt11.setOnAction(e -> createEllipse(1));
		bt20.setOnAction(e -> createRectangle(0));
		bt21.setOnAction(e -> createRectangle(1));
		bt30.setOnAction(e -> createPolygon());
		
		btClear.setOnAction(e -> {
			pane.getChildren().clear();
		});
		
		return vBox;		
	}
	
	//����ֱ�ߵķ���
	public void createLine() {
		Line line = new Line(10, 10 , 200 , 200);
		pane.getChildren().add(line);
	}
	
	//������Բ�ķ���
	public void createEllipse(int i) {
		Ellipse ellipse = new Ellipse(160, 110, 150, 100);
		ellipse.setStroke(Color.BLACK);
		
		if (i == 0) {
			ellipse.setFill(null);
		}
		else if (i == 1) {
			ellipse.setFill(Color.BURLYWOOD);
		}
		pane.getChildren().add(ellipse);
	}
	
	//�������εķ���
	public void createRectangle(int i) {
		Rectangle rectangle = new Rectangle(10, 10, 300, 200);
		rectangle.setStroke(Color.BLACK);
		
		if (i == 0) {
			rectangle.setFill(null);
		}
		else if (i == 1) {
			rectangle.setFill(Color.CADETBLUE);
		}
		pane.getChildren().add(rectangle);
	}
	
	//��������εķ���
	public void createPolygon() {
		
		Label label = new Label("����εı���Ϊ��");
		TextField textField = new TextField();
		Button submit = new Button("�ύ");
		HBox hBox = new HBox(label, textField, submit);
		hBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(hBox, 400, 70);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		
		textField.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				int n = Integer.parseInt(textField.getText());
				
				Polygon polygon = new Polygon();
				polygon.setStroke(Color.BLACK);
				polygon.setFill(null);
				ObservableList<Double> list = polygon.getPoints();
				
				double centerX = 160;
				double centerY = 110;
				double radius = 110;
				
				for (int i=0; i<n; i++) {
					list.add(centerX + radius * Math.cos(i * Math.PI / 3));
					list.add(centerY - radius * Math.sin(i * Math.PI / 3));
				}
				
				pane.getChildren().add(polygon);
				
				stage.close();
			}
		});
		submit.setOnAction(e -> {
			
			int n = Integer.parseInt(textField.getText());
			
			Polygon polygon = new Polygon();
			polygon.setStroke(Color.BLACK);
			polygon.setFill(null);
			ObservableList<Double> list = polygon.getPoints();
			
			double centerX = 160;
			double centerY = 110;
			double radius = 110;
			
			for (int i=0; i<n; i++) {
				list.add(centerX + radius * Math.cos(i * Math.PI / 3));
				list.add(centerY - radius * Math.sin(i * Math.PI / 3));
			}
			
			pane.getChildren().add(polygon);
			
			stage.close();
		});
		
		stage.setTitle("���������");
		stage.show();
			
	}
	
	
}
