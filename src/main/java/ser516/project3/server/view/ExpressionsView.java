package ser516.project3.server.view;

import ser516.project3.interfaces.ViewInterface;
import ser516.project3.model.ExpressionsModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;


/**
 * Class to create components in expressions panel 
 * and listeners for each component
 * 
 * @author Janani, Sangeetha, Ganesh
 *
 */
public class ExpressionsView extends JPanel implements ViewInterface {
	private JComboBox<Object> lowerFaceCombo;
	private JComboBox<Object> upperFaceCombo;
	private JComboBox<Object> eyeCombo;
	private JSpinner lowerFaceSpinner;
	private JSpinner upperFaceSpinner;
	private JToggleButton eyeAction;
	private JCheckBox eyeCheckBox;
	private ExpressionsModel expressionsModel;
	String[] lowerFaceList = { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" };
	String[] upperFaceList = { "Raise Brow", "Furrow Brow" };
	String[] eyeList = { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" };
	Dimension spinnerDimension = new Dimension(80,30);
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);

	/** 
     * Method to set expressions model
	 * @param expressionsModel-model object containing required expressions data.
	 * 
	 */
	public ExpressionsView(ExpressionsModel expressionsModel) {
		this.expressionsModel = expressionsModel;
	}

	/** 
     * Method to initialize the expressions view panel
	 * @param subViews-object of type ViewInterface
	 * 
	 */
	@Override
	public void initializeView(ViewInterface[] subViews) {

		GridBagLayout gbl_expressionPanel = new GridBagLayout();
		setLayout(gbl_expressionPanel);
		setBorder(
				new TitledBorder(null, "Expressions", TitledBorder.LEADING,
						TitledBorder.TOP, SUBFONT, null));

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		createLabels(gridBagConstraints);
		createComboBoxes(gridBagConstraints);
		createSpinners(gridBagConstraints);
		createActivateToggleButton(gridBagConstraints);
		createEyeCheckBox(gridBagConstraints);
	}
	
	/** 
     * Method to create labels in expressions panel
	 * @param gridBagConstraints-GridBagConstraints object to set the position
	 * 		  for each label
	 * 
	 */
	public void createLabels(GridBagConstraints gridBagConstraints) {
		JLabel lowerFaceLbl = new JLabel("Lower Face");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		add(lowerFaceLbl, gridBagConstraints);

		JLabel upperFaceLbl = new JLabel("Upper Face");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		add(upperFaceLbl, gridBagConstraints);

		JLabel eyeLabel = new JLabel("Eye");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		add(eyeLabel, gridBagConstraints);
	}

	/** 
     * Method to create ComboBoxes in expressions panel
	 * @param gridBagConstraints-GridBagConstraints object to set the position
	 * 		  for each combo box
	 * 
	 */
	public void createComboBoxes(GridBagConstraints gridBagConstraints) {
		lowerFaceCombo = new JComboBox<Object>();
		lowerFaceCombo.setModel(new DefaultComboBoxModel<Object>(lowerFaceList));
		lowerFaceCombo.setPreferredSize(new Dimension(120, 30));
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		add(lowerFaceCombo, gridBagConstraints);

		upperFaceCombo = new JComboBox<Object>();
		upperFaceCombo.setModel(new DefaultComboBoxModel<Object>(upperFaceList));
		upperFaceCombo.setPreferredSize(new Dimension(120, 30));
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		add(upperFaceCombo, gridBagConstraints);

		eyeCombo = new JComboBox<Object>();
		eyeCombo.setModel(new DefaultComboBoxModel<Object>(eyeList));
		eyeCombo.setPreferredSize(new Dimension(120, 30));
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		add(eyeCombo, gridBagConstraints);
	}
	
	/** 
     * Method to create spinners in expressions panel
	 * @param gridBagConstraints-GridBagConstraints object to set the position
	 * 		  for each spinners
	 * 
	 */
	public void createSpinners(GridBagConstraints gridBagConstraints) {
		SpinnerModel lowerFaceModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1);
		lowerFaceSpinner = new JSpinner(lowerFaceModel);
		lowerFaceSpinner.setPreferredSize(spinnerDimension);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		add(lowerFaceSpinner, gridBagConstraints);

		SpinnerModel upperFaceModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1);
		upperFaceSpinner = new JSpinner(upperFaceModel);
		upperFaceSpinner.setPreferredSize(spinnerDimension);
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		add(upperFaceSpinner, gridBagConstraints);
	}

	/** 
     * Method to create toggleButton in expressions panel
	 * @param gridBagConstraints-GridBagConstraints object to set the position
	 * 		  for toggleButton
	 * 
	 */
	public void createActivateToggleButton(GridBagConstraints gridBagConstraints) {
		eyeAction = new JToggleButton("Activate");
		eyeAction.setPreferredSize(new Dimension(90, 30));
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		add(eyeAction, gridBagConstraints);
	}
	
	/** 
     * Method to create CheckBox in expressions panel
	 * @param gridBagConstraints-GridBagConstraints object to set the position
	 * 		  for CheckBox
	 * 
	 */	
	public void createEyeCheckBox(GridBagConstraints gridBagConstraints) {
		eyeCheckBox = new JCheckBox("Auto Reset");
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		add(eyeCheckBox, gridBagConstraints);
	}
	
	/** 
     * Method to add ActionListener to LowerFace ComboBox
	 */
	public void addLowerFaceComboListener(ActionListener actionListener) {
		lowerFaceCombo.addActionListener(actionListener);
	}
	
	/** 
     * Method to add ActionListener to UpperFace ComboBox
	 */
	public void addUpperFaceComboListener(ActionListener actionListener) {
		upperFaceCombo.addActionListener(actionListener);
	}
	
	/** 
     * Method to add ActionListener to Eye ComboBox
	 */
	public void addEyeComboListener(ActionListener actionListener) {
		eyeCombo.addActionListener(actionListener);
	}
	
	/** 
     * Method to add ChangeListener to LowerFace Spinner
	 */
	public void addLowerFaceSpinnerChangeListener(ChangeListener changeListener) {
		lowerFaceSpinner.addChangeListener(changeListener);
	}

	/** 
     * Method to add ChangeListener to UpperFace Spinner
	 */
	public void addUpperFaceSpinnerChangeListener(ChangeListener changeListener) {
		upperFaceSpinner.addChangeListener(changeListener);
	}
	
	/** 
     * Method to add ItemListener to the activate toggle button
	 */
	public void addActivateToggleButtonItemListener(ItemListener itemListener) {
		eyeAction.addItemListener(itemListener);
	}

	/** 
     * Method to add ActionListener to CheckBox to Auto-Reset Eye action
	 */
	public void addEyeCheckBoxListener(ActionListener actionListener) {
		eyeCheckBox.addActionListener(actionListener);
	}
}