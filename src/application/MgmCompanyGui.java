package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This class represents the Management Company GUI.
 * 
 * @author Farnaz Eivazi
 * @version 7/11/2022 * 
 */

public class MgmCompanyGui extends Application {

	private static final int NUM_PIX = 15;
	private static final int SCALE_FACTOR = 40;
	private static final String MGMT_COMPANY = "Management Company";
	private TextField mgmNameText, mgmIdText, mgmFeeText, propNameText, propCityText, propRentText, propOwnerText,
			propPlotXText, propPlotYText, propPlotWidthText, propPlotDepthText;
	private Label mgmNameLabel, mgmIdLabel, mgmFeeLabel, propNameLabel, propCityLabel, propRentLabel, propOwnerLabel,
			propXLabel, propYLabel, propWidthLabel, propDepthLabel;

	private Button newMgmBtn, addPropertyBtn, maxRentBtn, totalRentBtn, propListBtn, exitBtn;
	Group plotFrame = new Group();
	private ManagementCompany mgmCompany;

	private void createManagementCompanyLabels() {
		mgmNameLabel = new Label("Name:");
		mgmIdLabel = new Label("Tax Id:");
		mgmFeeLabel = new Label("Fee %:");
	}

	private void createManagementCompanyTextFields() {
		mgmNameText = new TextField();
		mgmNameText.setMaxWidth(100);

		mgmIdText = new TextField();
		mgmIdText.setMaxWidth(80);

		mgmFeeText = new TextField();
		mgmFeeText.setMaxWidth(40);
	}

	private void buildManagementCompanyComponents() {
		createManagementCompanyLabels();
		createManagementCompanyTextFields();
	}

	private void addMgmtComponentsToMainPane(VBox mgmPane) {
		HBox mgmtComponentsPane = new HBox(5);
		mgmtComponentsPane.getChildren().addAll(mgmNameLabel, mgmNameText);
		mgmtComponentsPane.getChildren().addAll(mgmIdLabel, mgmIdText);
		mgmtComponentsPane.getChildren().addAll(mgmFeeLabel, mgmFeeText);
		mgmPane.getChildren().addAll(mgmtComponentsPane);
	}

	private void configureMgmtTitlePane(TitledPane mgmTitlePane) {
		mgmTitlePane.setCollapsible(false);
		mgmTitlePane.setMaxWidth(450);
		mgmTitlePane.setPadding(new Insets(20, 10, 5, 10));
	}

	private void createPropertyLabels() {
		propNameLabel = new Label("Property Name");
		propCityLabel = new Label("City");
		propRentLabel = new Label("Rent");
		propOwnerLabel = new Label("Owner");

		propXLabel = new Label("Plot X Value");
		propYLabel = new Label("Plot Y Value");
		propWidthLabel = new Label("Plot Width");
		propDepthLabel = new Label("Plot Depth");
	}

	private void createPropertyTextFields() {
		propNameText = new TextField();
		propNameText.setMaxWidth(100);

		propCityText = new TextField();
		propCityText.setMaxWidth(80);

		propRentText = new TextField();
		propRentText.setMaxWidth(80);

		propOwnerText = new TextField();
		propOwnerText.setMaxWidth(100);

		propPlotXText = new TextField();
		propPlotXText.setMaxWidth(100);

		propPlotYText = new TextField();
		propPlotYText.setMaxWidth(100);

		propPlotWidthText = new TextField();
		propPlotWidthText.setMaxWidth(100);

		propPlotDepthText = new TextField();
		propPlotDepthText.setMaxWidth(100);
	}

	private void disablePropertyTextFields() {
		propNameText.setEditable(false);
		propCityText.setEditable(false);
		propRentText.setEditable(false);
		propOwnerText.setEditable(false);
		propPlotXText.setEditable(false);
		propPlotYText.setEditable(false);
		propPlotWidthText.setEditable(false);
		propPlotDepthText.setEditable(false);
	}

	private void buildPropertyComponents() {
		createPropertyLabels();
		createPropertyTextFields();
		disablePropertyTextFields();
	}

	private void addComponentsToPropertyComponentsPane(VBox propertyComponentsPane) {
		propertyComponentsPane.getChildren().addAll(propNameLabel, propNameText);
		propertyComponentsPane.getChildren().addAll(propCityLabel, propCityText);
		propertyComponentsPane.getChildren().addAll(propRentLabel, propRentText);
		propertyComponentsPane.getChildren().addAll(propOwnerLabel, propOwnerText);
		VBox.setMargin(propertyComponentsPane, new Insets(5, 30, 10, 30));
	}

	private void addComponentsToPropertyPlotPane(VBox propPlotPane) {
		propPlotPane.getChildren().addAll(propXLabel, propPlotXText);
		propPlotPane.getChildren().addAll(propYLabel, propPlotYText);
		propPlotPane.getChildren().addAll(propWidthLabel, propPlotWidthText);
		propPlotPane.getChildren().addAll(propDepthLabel, propPlotDepthText);
		VBox.setMargin(propPlotPane, new Insets(5, 30, 10, 30));
	}

	private void configurePropertyTitlePane(TitledPane propertyTitlePane) {
		propertyTitlePane.setCollapsible(false);
		propertyTitlePane.setMaxWidth(500);
		propertyTitlePane.setPadding(new Insets(5, 120, 10, 120));
	}

	private void createButtons() {
		newMgmBtn = new Button("New Management Company");
		addPropertyBtn = new Button("Add Property");
		maxRentBtn = new Button("Max Rent");
		totalRentBtn = new Button("Total Rents");
		propListBtn = new Button("List of Properties");
		exitBtn = new Button("Exit");
	}

	private void disableButtons() {
		addPropertyBtn.setDisable(true);
		maxRentBtn.setDisable(true);
		totalRentBtn.setDisable(true);
		propListBtn.setDisable(true);
	}

	private void addFirstRowButtonsPane(HBox buttonPane) {
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(newMgmBtn, addPropertyBtn, maxRentBtn);
	}

	private void addSecondRowButtonsPane(HBox buttonPane) {
		buttonPane.setPadding(new Insets(10, 0, 10, 0));
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(totalRentBtn, propListBtn, exitBtn);
	}

	private void addButtonsToMainPane(VBox mainPane) {
		HBox buttonPane1 = new HBox(20);
		addFirstRowButtonsPane(buttonPane1);

		HBox buttonPane2 = new HBox(20);
		addSecondRowButtonsPane(buttonPane2);
		mainPane.getChildren().addAll(buttonPane1, buttonPane2);
	}

	private void setButtonActions() {
		newMgmBtn.setOnAction(new ButtonEventHandler());
		addPropertyBtn.setOnAction(new ButtonEventHandler());
		maxRentBtn.setOnAction(new ButtonEventHandler());
		propListBtn.setOnAction(new ButtonEventHandler());
		totalRentBtn.setOnAction(new ButtonEventHandler());
		exitBtn.setOnAction(new ButtonEventHandler());
	}

	// Handler class.
	private class ButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (e.getSource() == newMgmBtn) {
				createNewMgm();
			} else if (e.getSource() == addPropertyBtn) {
				addProp();
			} else if (e.getSource() == maxRentBtn) {
				displayAlertBox(displayHighetstRentPropertyInfo());
			} else if (e.getSource() == totalRentBtn) {
				displayAlertBox("Total Rent of the properties: " + mgmCompany.getTotalRent());
			} else if (e.getSource() == propListBtn) {
				displayAlertBox(mgmCompany.toString());
			} else if (e.getSource() == exitBtn)

				System.exit(0);
		}
	}
	
	private String displayHighetstRentPropertyInfo() {
		Property highestRentProperty = mgmCompany.getHighestRentProperty();
		String value = "Property Name: " + highestRentProperty.getPropertyName() + 
				"\n Located in " + highestRentProperty.getCity() + "\n Belonging to: " + highestRentProperty.getOwner()
								+ "\n Rent Amount: " + highestRentProperty.getRentAmount();
		return value;
	}

	/**
	 * Creates a ManagementCompany object using information from the GUI and sets
	 * the text fields to
	 */
	private void createNewMgm() {
		if (!isMgmFieldEmpty()) {
			if (isTaxFeeInvalid()) {
				handleInvalidMgmtFee();
			} else {
				if (true) {
					// Create management company object with default Plot
					mgmCompany = new ManagementCompany(mgmNameText.getText(), mgmIdText.getText(),
							Double.parseDouble(mgmFeeText.getText()));
					setPropertyButtons();
					setManagmentTextFields();
					setPropertyTextFields();
					setPlotWindow();
				}
			}
		}
	}

	// draw proposed plot rectangle
	private void drawPropertyPlot(Rectangle propRectangle, Property property) {
		int rectW = Math.min(400, property.getPlot().getWidth() * SCALE_FACTOR);
		int rectD = Math.min(400, property.getPlot().getDepth() * SCALE_FACTOR);
		int rectX = Math.min(400, property.getPlot().getX() * SCALE_FACTOR);
		int rectY = Math.min(400, property.getPlot().getY() * SCALE_FACTOR);
		propRectangle = new Rectangle(rectX, rectY, rectW, rectD);
		propRectangle.setFill(Color.TRANSPARENT);
		propRectangle.setStroke(Color.RED);
		propRectangle.setStrokeWidth(2);
		plotFrame.getChildren().addAll(propRectangle);
		displayAlertBox("Note the property's Plot location\n");
	}

	private void displayAlertBox(String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Management Company");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}

	/**
	 * Create a property object and calls mgmCompany method to add it to the list of
	 * properties. If the property can not be added an error message will be
	 * displayed.
	 */
	private void addProp() {
		if (!isPropertyFieldEmpty()) {
			Property property = null;
			if (isPropertyPlotFieldEmpty()) {
				property = buildPropertyWithDefaultPlot();
			} else {
				property = buildPropertyWithGivenPlot();
			}

			Rectangle propRectangle = null;
			drawPropertyPlot(propRectangle, property);

			int rtnValue = mgmCompany.addProperty(property);
			switch (rtnValue) {
			case -1: {
				alertPropertiesArrayFull();
				plotFrame.getChildren().remove(propRectangle);
				break;
			}
			case -2: {
				alertPropertyIsNull(property);
				plotFrame.getChildren().remove(propRectangle);
				break;
			}
			case -3: {
				alertDoesNotEncompass(property);
				plotFrame.getChildren().remove(propRectangle);
				break;
			}
			case -4: {
				alertOverlap(property);
				plotFrame.getChildren().remove(propRectangle);
				break;
			}
			default: // the case where property is valid and created - now display icon
				ArrayList<String> pixList = shufflePix();
				ImageView icon;
				int nextPix = 0;
				icon = new ImageView(pixList.get(nextPix++));
				icon.setX(property.getPlot().getX() * SCALE_FACTOR);
				icon.setY(property.getPlot().getY() * SCALE_FACTOR);
				double propWidth = Math.min(400, property.getPlot().getWidth() * SCALE_FACTOR);
				double propDepth = Math.min(400, property.getPlot().getDepth() * SCALE_FACTOR);
				icon.setFitWidth(propWidth);
				icon.setFitHeight(propDepth);
				icon.setSmooth(true);
				plotFrame.getChildren().addAll(icon);

				displayAlertBox("Property " + property.getPropertyName() + " was added\n");
				break;
			}
		}
	}

	public ArrayList<String> shufflePix() {
		String[] pix = { "Apartments.jpg", "BaseballField.jpg", "BlueApts.jpg", "GasStation.jpg", "GrayRoofedHouse.jpg",
				"HighRiseApts.jpg", "MiniMart.jpg", "NM_House.jpg", "OfficeBldg.jpg", "Orchard.jpg", "Patio.jpg",
				"Pool.jpg", "School.jpg", "Shop.jpg", "TennisCourt.jpg" };
		ArrayList<String> rtnList = new ArrayList<>();
		for (int i = 0; i < NUM_PIX; i++) {
			rtnList.add("file:src\\images\\" + pix[i]);
		}
		Collections.shuffle(rtnList);
		return rtnList;
	}

	private void alertPropertiesArrayFull() {
		displayAlertBox("This Property can not be managed by this company.\n"
				+ "  The maximum capacity to manage for this company is :  " + mgmCompany.MAX_PROPERTY);
	}

	private void alertPropertyIsNull(Property prop) {
		displayAlertBox("Property " + prop.getPropertyName() + " is null\n");
	}

	private void alertDoesNotEncompass(Property prop) {
		displayAlertBox("Property " + prop.getPropertyName() + " is not within the limits of Management Company "
				+ mgmCompany.getName() + "\n");
	}

	private void alertOverlap(Property prop) {
		displayAlertBox("Property " + prop.getPropertyName()
				+ "'s plot overlaps another property managed by Management Company " + mgmCompany.getName() + "\n");
	}

	private Property buildPropertyWithDefaultPlot() {
		return new Property(propNameText.getText(), propCityText.getText(), Double.parseDouble(propRentText.getText()),
				propOwnerText.getText());
	}

	private Property buildPropertyWithGivenPlot() {
		Property p;

		try {
			p = new Property(propNameText.getText(), propCityText.getText(), Double.parseDouble(propRentText.getText()),
					propOwnerText.getText(), Integer.parseInt(propPlotXText.getText()),
					Integer.parseInt(propPlotYText.getText()), Integer.parseInt(propPlotWidthText.getText()),
					Integer.parseInt(propPlotDepthText.getText()));
		} catch (NumberFormatException e) {
			displayAlertBox("Plot location textfields are not integers\n");
			System.out.println("NumberFormatException in property Plot Fields");
			p = new Property(propNameText.getText(), propCityText.getText(), Double.parseDouble("1000.0"),
					propOwnerText.getText());
		}

		return p;
	}

	/**
	 * 
	 * @return true if any of the field related to the property is empty, false
	 *         otherwise
	 */
	private boolean isPropertyFieldEmpty() {
		return (propNameText.getText().equals("") || propCityText.getText().equals("")
				|| propRentText.getText().equals("") || propOwnerText.getText().equals(""));
	}

	/**
	 * 
	 * @return true if any of the plot fields related to a property is empty, false
	 *         otherwise
	 */
	private boolean isPropertyPlotFieldEmpty() {
		return (propPlotXText.getText().equals("") || propPlotYText.getText().equals("")
				|| propPlotWidthText.getText().equals("") || propPlotDepthText.getText().equals(""));
	}

	private void handleInvalidMgmtFee() {
		displayAlertBox("Fee is not valid, Correct value is between 0-100");
	}

	private void setPropertyButtons() {
		newMgmBtn.setDisable(true);
		addPropertyBtn.setDisable(false);
		maxRentBtn.setDisable(false);
		totalRentBtn.setDisable(false);
		propListBtn.setDisable(false);
	}

	private void setManagmentTextFields() {
		mgmNameText.setEditable(false);
		mgmIdText.setEditable(false);
		mgmFeeText.setEditable(false);
		newMgmBtn.setDisable(true);
	}

	private void setPropertyTextFields() {
		propNameText.setEditable(true);
		propCityText.setEditable(true);
		propRentText.setEditable(true);
		propOwnerText.setEditable(true);
		propPlotXText.setEditable(true);
		propPlotYText.setEditable(true);
		propPlotWidthText.setEditable(true);
		propPlotDepthText.setEditable(true);
	}

	// set up Plot window for Mgmt Company
	private void setPlotWindow() {
		Stage stage2 = new Stage();
		int sceneWidth = Math.min(400, mgmCompany.getPlot().getWidth() * SCALE_FACTOR);
		int sceneDepth = Math.min(400, mgmCompany.getPlot().getDepth() * SCALE_FACTOR);

		Rectangle mgmtRectangle = new Rectangle(0, 0, sceneWidth, sceneDepth);
		mgmtRectangle.setFill(Color.TRANSPARENT);
		mgmtRectangle.setStroke(Color.RED);
		mgmtRectangle.setStrokeWidth(2);
		plotFrame.getChildren().addAll(mgmtRectangle);
		stage2.setScene(new Scene(plotFrame, sceneWidth, sceneDepth));
		stage2.setX(10);
		stage2.setY(10);
		// Set stage title and show the stage.
		stage2.setTitle(mgmCompany.getName() + " plot. Property plots must fit inside this.");
		stage2.show();
	}

	/**
	 * 
	 * @return true if any of the field related to the management company is empty,
	 *         false otherwise
	 */
	private boolean isMgmFieldEmpty() {
		return (mgmNameText.getText().equals("") || mgmIdText.getText().equals("") || mgmFeeText.getText().equals(""));
	}

	private boolean isTaxFeeInvalid() {
		return (Double.parseDouble(mgmFeeText.getText()) < 0 || Double.parseDouble(mgmFeeText.getText()) > 100);
	}

	@Override
	public void start(Stage stage) {
		// Main Pane
		VBox mainPane = new VBox();

		buildManagementCompanyComponents();

		// Management company pane
		VBox mgmPane = new VBox(5);
		addMgmtComponentsToMainPane(mgmPane);

		TitledPane mgmTitlePane = new TitledPane(MGMT_COMPANY, mgmPane);
		configureMgmtTitlePane(mgmTitlePane);

		buildPropertyComponents();

		// Create property pane
		HBox propertyPane = new HBox();
		VBox propertyComponentsPane = new VBox();
		VBox propPlotPane = new VBox();
		addComponentsToPropertyComponentsPane(propertyComponentsPane);
		addComponentsToPropertyPlotPane(propPlotPane);

		propertyPane.getChildren().addAll(propertyComponentsPane, propPlotPane);
		HBox.setMargin(propertyPane, new Insets(5, 150, 10, 100));

		TitledPane propertyTitlePane = new TitledPane("Property Information", propertyPane);
		configurePropertyTitlePane(propertyTitlePane);
		mainPane.getChildren().addAll(mgmTitlePane, propertyTitlePane);

		createButtons();
		disableButtons();
		setButtonActions();

		addButtonsToMainPane(mainPane);

		Scene scene = new Scene(mainPane, 450, 430);
		stage.setScene(scene);

		// Set stage title and show the stage.
		stage.setTitle("Property Management ");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
