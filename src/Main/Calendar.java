package Main;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Calendar extends Application {
	HBox hBox = new HBox();
	
	VBox vBox = new VBox();
	
	HBox hBox1 = new HBox();
	ComboBox<String> cbo1 = new ComboBox<>();
	String[] yearList = new String[300];	
	ObservableList<String> items1;
	ComboBox<String> cbo2 = new ComboBox<>();
	String[] monthList = new String[12];	
	ObservableList<String> items2;
	GregorianCalendar gc = new GregorianCalendar();
	int year = gc.get(java.util.Calendar.YEAR);
	int month = gc.get(java.util.Calendar.MONTH);
	int date = gc.get(java.util.Calendar.DAY_OF_MONTH);
	TextField tf = new TextField();	
	Image image;
	ImageView iv;
	int hourOfClock;
	int minuteOfClock;
	
	HBox hBox2 = new HBox();
	Button[] weekList = new Button[] {new Button("日"), new Button("一"), new Button("二"), new Button("三"), new Button("四"), new Button("五"), new Button("六")};
	
	FlowPane flowPane = new FlowPane();
	Button[] dateList = new Button[32];
	
	//右边栏
	VBox vBox1 = new VBox();
	FlowPane fl = new FlowPane();
	Button btLunarLabel = new Button("农历");
	Button btLunarDisplay;
	Button btExit = new Button("EXIT");
	
	@Override
	public void start(Stage primaryStage) throws ParseException {
		
		HBox hBox0 = getPane();
		
		btExit.setOnAction(e -> primaryStage.close());
		
		EventHandler<ActionEvent> eventHandler = e -> {
			getCurrentTime();
			clockActivate();
			};
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		Scene primaryScene = new Scene(hBox0, 500, 400);
		primaryStage.setTitle("王岩立课程设计——万年历");
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public HBox getPane() throws ParseException {
		
		for (int i=1800; i<2100; i++) {
			yearList[i-1800] = i + "年";
			cbo1.getItems().add(yearList[i-1800]);
		}
		for (int i=0; i<12; i++) {
			monthList[i] = i+1 + "月";
			cbo2.getItems().add(monthList[i]);
		}
		
		items1 = FXCollections.observableArrayList(yearList);
		items2 = FXCollections.observableArrayList(monthList);
		
		
		cbo1.setPrefSize(90, 30);
		cbo2.setPrefSize(90, 30);
		tf.setPrefSize(90, 30);
		
		Pane pane = new Pane();
		pane.setPrefSize(30, 50);
		
		image = new Image("file:src/src/clock.png");
		iv = new ImageView(image);
		iv.setFitHeight(50);
		iv.setFitWidth(50);
		
		
		hBox1.getChildren().addAll(cbo1, cbo2, tf, pane, iv);
		
		hBox2.setMaxWidth(350);
		for (int i=0; i<7; i++) {
			weekList[i].setPrefSize(50, 50);
			weekList[i].setStyle("-fx-border-color: #000000; -fx-background-color: #d71345; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
			hBox2.getChildren().add(weekList[i]);	
		}
		
		
		cbo1.setValue(year + "年");
		cbo2.setValue(month + 1 + "月");
		cbo1.setStyle("-fx-border-color: #000000; -fx-background-color: #fab27b; -fx-font-size: 10px; -fx-text-fill: white; -fx-font-weight:bold");
		cbo2.setStyle("-fx-border-color: #000000; -fx-background-color: #fab27b; -fx-font-size: 10px; -fx-text-fill: white; -fx-font-weight:bold");
		
		
		getLunar(year-1800, month-1, date+1);
		
		display(items1.indexOf(cbo1.getValue()), items2.indexOf(cbo2.getValue()));
		
		
		//点击下拉菜单触发刷新日历
		cbo1.setOnAction(e -> {
			try {
				display(items1.indexOf(cbo1.getValue()), items2.indexOf(cbo2.getValue()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		cbo2.setOnAction(e -> {
			try {
				display(items1.indexOf(cbo1.getValue()), items2.indexOf(cbo2.getValue()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		

		vBox.getChildren().addAll(hBox1, hBox2, flowPane);
		vBox.setMinWidth(350);
		
		Button btSetClock = new Button("set clock");
		btSetClock.setPrefSize(150, 50);
		btSetClock.setStyle("-fx-border-color: #000000; -fx-background-color: #ea66a6; -fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight:bold");
		btSetClock.setOnAction(e -> setClock());
		
		Button btCalc = new Button("计算器");
		btCalc.setPrefSize(150, 50);
		btCalc.setStyle("-fx-border-color: #000000; -fx-background-color: #c77eb5; -fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight:bold");
		btCalc.setOnAction(e -> new Calculator().start(new Stage()));
		
		Button btDraw = new Button("绘制图形");
		btDraw.setPrefSize(150, 50);
		btDraw.setStyle("-fx-border-color: #000000; -fx-background-color: #c77eb5; -fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight:bold");
		btDraw.setOnAction(e -> new Drawing().start(new Stage()));
		

		btExit.setPrefSize(150, 70);
		btExit.setStyle("-fx-border-color: #000000; -fx-background-color: red; -fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight:bold");

		
		vBox1.getChildren().addAll(fl, btSetClock, btCalc, btDraw, btExit);
		
		hBox.getChildren().addAll(vBox, vBox1);
		
		return hBox;
	}
	
	public void display(int indexOfYear, int indexOfMonth) throws ParseException {
		
		//清空flowPane，防止在上个月份日历后面继续添加新的月份的日历
		flowPane.getChildren().clear();
		flowPane.setMaxWidth(350);
		
		for (int i=1; i<=31; i++) {
			dateList[i] = new Button(i + "");
			dateList[i].setPrefSize(50, 50);
			
			if (i != date) {
				dateList[i].setStyle("-fx-border-color: #000000; -fx-background-color: #5c7a29; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
			}
			else {
				dateList[i].setStyle("-fx-border-color: #000000; -fx-background-color: orange; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight:bold");
			}
			int index = i;
			dateList[i].setOnAction(e -> {
				getLunar(indexOfYear, indexOfMonth, index);
				});
		}
		
		String str = (indexOfYear + 1800) + "-" + (indexOfMonth + 1) + "-01";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		
		gregorianCalendar.set(GregorianCalendar.DAY_OF_MONTH,1);
		
		//获取一号是星期几
		int dayOfWeek = gregorianCalendar.get(GregorianCalendar.DAY_OF_WEEK);
		
		for (int i=1; i<dayOfWeek; i++) {
			dateList[0] = new Button("");
			dateList[0].setPrefSize(50, 50);
			flowPane.getChildren().add(dateList[0]);
		}
		
		//获取该月最后一天
		int lastDay = gregorianCalendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		for (int i=1; i<=lastDay; i++) {
			flowPane.getChildren().add(dateList[i]);
		}

	}
	
	public void getCurrentTime() {
		GregorianCalendar cal = new GregorianCalendar();
		
		int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int minute = cal.get(java.util.Calendar.MINUTE);
		int second = cal.get(java.util.Calendar.SECOND);
		
		tf.setText(hour + " : " + minute + " : " + second);	
		
		
	}
	
	public void setClock() {
		HBox hBox3 = new HBox();
		
		ComboBox<String> cbo3 = new ComboBox<>();
		String[] hourList = new String[24];			
		for (int i=0; i<24; i++) {
			hourList[i] = i + "";
			cbo3.getItems().add(hourList[i]);
		}
		ObservableList<String> items3 = FXCollections.observableArrayList(hourList);
		
		ComboBox<String> cbo4 = new ComboBox<>();
		String[] minuteList = new String[60];	
		for (int i=0; i<60; i++) {
			minuteList[i] = i + "";
			cbo4.getItems().add(minuteList[i]);
		}
		ObservableList<String> items4 = FXCollections.observableArrayList(minuteList);
		
		Button btSubmit = new Button("submit");
		
		cbo3.setPrefSize(90, 30);
		cbo4.setPrefSize(90, 30);
		btSubmit.setPrefSize(90, 30);
		
		GregorianCalendar cal0 = new GregorianCalendar();
		
		int hour0 = cal0.get(java.util.Calendar.HOUR_OF_DAY);
		int minute0 = cal0.get(java.util.Calendar.MINUTE);
		cbo3.setValue(hour0 + "");
		cbo4.setValue(minute0 + "");
		
		hBox3.getChildren().addAll(cbo3, cbo4, btSubmit);
		hBox3.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(hBox3, 400, 70);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		
		btSubmit.setOnAction(e -> {
			
			hourOfClock = items3.indexOf(cbo3.getValue());
			minuteOfClock = items4.indexOf(cbo4.getValue());
			image = new Image("file:src/src/clock.gif");
			iv = new ImageView(image);
			iv.setFitHeight(50);
			iv.setFitWidth(50);
			hBox1.getChildren().remove(4, 5);
			hBox1.getChildren().add(iv);
			stage.close();
		});
		
		stage.setTitle("设置闹钟");
		stage.show();
	}
	
	public void clockActivate() {
		GregorianCalendar cal1 = new GregorianCalendar();
		int hour1 = cal1.get(java.util.Calendar.HOUR_OF_DAY);
		int minute1 = cal1.get(java.util.Calendar.MINUTE);
		if (hour1 == hourOfClock && minute1 == minuteOfClock) {
			
			image = new Image("file:src/src/clockActivate.gif");
			iv = new ImageView(image);
			iv.setFitHeight(50);
			iv.setFitWidth(50);
			hBox1.getChildren().remove(4, 5);
			hBox1.getChildren().add(iv);
			
		}
	}
	
	public void getLunar(int indexOfYear, int indexOfMonth, int index) {
		fl.getChildren().clear();
		SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Calendar clickDate = GregorianCalendar.getInstance();
		String str = (indexOfYear + 1800) + "-" + (indexOfMonth + 1) + "-" + index;
        try {
        	clickDate.setTime(chineseDateFormat.parse(str));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Lunar lunar = new Lunar(clickDate);
        
        btLunarDisplay = new Button((lunar + "").substring(0,3) + "\n\n" + (lunar + "").substring(3));
        
        btLunarLabel.setPrefSize(150, 30);
        btLunarDisplay.setPrefSize(150, 150);
        
        btLunarLabel.setStyle("-fx-border-color: #000000; -fx-background-color: #6950a1; -fx-font-size: 13px; -fx-text-fill: white; -fx-font-weight:bold");
        btLunarDisplay.setStyle("-fx-border-color: #000000; -fx-background-color: #63434f; -fx-font-size: 23px; -fx-text-fill: white; -fx-font-weight:bold");
        
        fl.getChildren().addAll(btLunarLabel, btLunarDisplay);
        
	}
}
