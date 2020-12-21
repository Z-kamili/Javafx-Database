package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import  javafx.scene.control.Label;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {
	@FXML Label dbcon; 
	@FXML javafx.scene.control.TextField username;
	@FXML javafx.scene.control.TextField password;
	@FXML Label check;
	public void statusDB() throws IOException,SQLException{
		
		if(!AdminsDB.getConnection().isClosed()){
			
			dbcon.setText("Connected");
		}else {
			
			
			dbcon.setText("Not Connected ");
		}
		
	}
	
	
	@FXML
	public void enterCP() throws IOException,SQLException{
		
		
		List<Admins> list = AdminsDB.getAdmins();
		Map<String,String> map = new HashMap<String,String>();
		boolean test = false;
		
		for(Admins a:list){
			
			map.put(a.getUsername(),a.getPassword());
			
			
		}
		 for (Map.Entry<String,String> entry : map.entrySet())  {
			 if(entry.getKey().equals(username.getText()) && entry.getValue().equals(password.getText())){
				 
				 test = true;
				 break;
				 
			 }
			 
		 }
		 
		 if(test) {
			 
			 check.setText("Success");
			 
				try {
					Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
					Scene scene = new Scene(root,700,400);
					Stage primaryStage = new Stage();
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				 }catch(Exception e) {
					e.printStackTrace();
				}		
			 
		 }else {
			 
			 check.setText("Failed");
			 
		 }
	           
	    } 
	

}
