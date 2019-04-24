package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GameLogController implements Initializable {
	@FXML
	private TextField usernameField;
	
	@FXML private Button buttonExit;
	@FXML private Button buttonEnterBroken;
	@FXML private Button buttonEnterMissing;
	
	
	@FXML private TextField fieldBroken;
	@FXML private TextField fieldMissing;
	
	@FXML private TextArea displayBroken;
	@FXML private TextArea displayMissing;
	
	@FXML private ListView<String> listXbox;
	
	
	ObservableList<String> items = FXCollections.observableArrayList();
	
	
	
	
	
	
	// important database stuff
	DatabaseConnector dbc = new DatabaseConnector();
	ResultSet result = null;
	ResultSet rs = null;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			setDisplay();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// set
	public void setDisplay() throws SQLException {


	}


	
	
	// add broken items
	public void addBroken(ActionEvent addBroken) {
		// gets text inside box
		String input = fieldBroken.getText();

		// adds text into display box
		displayBroken.appendText(input + "\n");
		
		// clears field for next entry?
		fieldBroken.clear();
		
	}
	
	// add missing items
	public void addMissing(ActionEvent addMissing) {
		// gets text inside box
		String input = fieldMissing.getText();

		// adds text into display box
		displayMissing.appendText(input + "\n");
		
		// clears field for next entry?
		fieldMissing.clear();
			
		}


	// test
	public void exit() {
		System.exit(0);
	}

}
