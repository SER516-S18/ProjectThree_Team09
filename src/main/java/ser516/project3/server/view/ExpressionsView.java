package ser516.project3.server.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ser516.project3.model.MessageModel.AbstractExpression;
import ser516.project3.model.MessageModel.ConcreteExpression;
import ser516.project3.utilities.ServerCommonData;


/**
 * Class to create components in expressions panel 
 * and listeners for each component
 * 
 * @author Janani, Sangeetha, Ganesh
 *
 */
public class ExpressionsView  {
	JPanel expressionPanel;
	String[] lowerFaceList = { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" };
	String[] upperFaceList = { "Raise Brow", "Furrow Brow" };
	String[] eyeList = { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" };
	Dimension spinnerDimension = new Dimension(80,30);
	private static final Font SUBFONT = new Font("Courier New", Font.BOLD, 14);
	
	// Constructor to initialize expression panel.
	public ExpressionsView() {	
		expressionPanel = new JPanel();
		
		JLabel lowerFaceLbl = new JLabel("Lower Face");

		GridBagLayout gbl_expressionPanel = new GridBagLayout();
		expressionPanel.setLayout(gbl_expressionPanel);
		expressionPanel.setBorder(
				new TitledBorder(null, "Expressions", TitledBorder.LEADING, 
						TitledBorder.TOP, SUBFONT, null));

		GridBagConstraints lowerFaceGbc = new GridBagConstraints();
		lowerFaceGbc.gridx = 1;
		lowerFaceGbc.gridy = 0;
		expressionPanel.add(lowerFaceLbl, lowerFaceGbc);

		JComboBox<Object> lowerFaceCombo = new JComboBox<Object>();
		lowerFaceCombo.setModel(new DefaultComboBoxModel<Object>(lowerFaceList));
		lowerFaceCombo.setPreferredSize(new Dimension(120, 30));
		GridBagConstraints lowerFaceComboGbc = new GridBagConstraints();
		lowerFaceComboGbc.gridx = 2;
		lowerFaceComboGbc.gridy = 0;
		expressionPanel.add(lowerFaceCombo, lowerFaceComboGbc);

		SpinnerModel lowerFaceModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1);
		JSpinner lowerFaceSpinner = new JSpinner(lowerFaceModel);

		lowerFaceSpinner.setPreferredSize(spinnerDimension);
		GridBagConstraints lowerFaceActGbc = new GridBagConstraints();
		lowerFaceActGbc.gridx = 3;
		lowerFaceActGbc.gridy = 0;
		expressionPanel.add(lowerFaceSpinner, lowerFaceActGbc);

		JLabel upperFaceLbl = new JLabel("Upper Face");
		GridBagConstraints upperFaceGbc = new GridBagConstraints();
		upperFaceGbc.gridx = 1;
		upperFaceGbc.gridy = 1;
		expressionPanel.add(upperFaceLbl, upperFaceGbc);

		JComboBox<Object> upperFaceCombo = new JComboBox<Object>();
		upperFaceCombo.setModel(new DefaultComboBoxModel<Object>(upperFaceList));
		upperFaceCombo.setPreferredSize(new Dimension(120, 30));

		GridBagConstraints upperFaceComboGbc = new GridBagConstraints();
		upperFaceComboGbc.gridx = 2;
		upperFaceComboGbc.gridy = 1;
		expressionPanel.add(upperFaceCombo, upperFaceComboGbc);

		SpinnerModel upperFaceModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1);
		JSpinner upperFaceSpinner = new JSpinner(upperFaceModel);

		upperFaceSpinner.setPreferredSize(spinnerDimension);
		GridBagConstraints upperFaceActGbc = new GridBagConstraints();
		upperFaceActGbc.gridx = 3;
		upperFaceActGbc.gridy = 1;
		expressionPanel.add(upperFaceSpinner, upperFaceActGbc);

		JLabel eyeLabel = new JLabel("Eye");
		GridBagConstraints eyeGbc = new GridBagConstraints();
		eyeGbc.gridx = 1;
		eyeGbc.gridy = 2;
		expressionPanel.add(eyeLabel, eyeGbc);

		JComboBox<Object> eyeCombo = new JComboBox<Object>();
		eyeCombo.setModel(new DefaultComboBoxModel<Object>(eyeList));
		eyeCombo.setPreferredSize(new Dimension(120, 30));

		GridBagConstraints eyeComboGbc = new GridBagConstraints();
		eyeComboGbc.gridx = 2;
		eyeComboGbc.gridy = 2;
		expressionPanel.add(eyeCombo, eyeComboGbc);

		JToggleButton eyeAct = new JToggleButton("Activate");
		eyeAct.setPreferredSize(new Dimension(90, 30));
		GridBagConstraints eyeActGbc = new GridBagConstraints();
		eyeActGbc.gridx = 3;
		eyeActGbc.gridy = 2;
		expressionPanel.add(eyeAct, eyeActGbc);

		JCheckBox eyeCheckBox = new JCheckBox("Auto Reset");
		GridBagConstraints eyeCheckBoxGbc = new GridBagConstraints();
		eyeCheckBoxGbc.gridx = 4;
		eyeCheckBoxGbc.gridy = 2;
		expressionPanel.add(eyeCheckBox, eyeCheckBoxGbc);

		lowerFaceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String attribute = String.valueOf(lowerFaceCombo.getSelectedItem());
				Double value = (Double) lowerFaceSpinner.getValue();
				updateLowerFace(attribute, value);
			}
		});

		lowerFaceSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String attribute = String.valueOf(lowerFaceCombo.getSelectedItem());
				Double value = (Double) lowerFaceSpinner.getValue();
				updateLowerFace(attribute, value);
			}
		});

		upperFaceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String attribute = String.valueOf(upperFaceCombo.getSelectedItem());
				Double value = (Double) upperFaceSpinner.getValue();
				updateUpperFace(attribute, value);
			}
		});

		upperFaceSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String attribute = String.valueOf(upperFaceCombo.getSelectedItem());
				Double value = (Double) upperFaceSpinner.getValue();
				updateUpperFace(attribute, value);
			}
		});

		eyeCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String attribute = String.valueOf(eyeCombo.getSelectedItem());
				Boolean eyeStatus = eyeAct.isSelected();
				updateEye(attribute, eyeStatus);
			}
		});

		eyeAct.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				String attribute = String.valueOf(eyeCombo.getSelectedItem());
				Boolean eyeStatus = eyeAct.isSelected();
				updateEye(attribute, eyeStatus);
			}
		});

		eyeCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// To be implemented
				// AbstractButton abstractButton = (AbstractButton) e.getSource();
				// updateEyeAutoReset(abstractButton.getModel().isSelected());

			}
		});
	}
	
	// Method that returns the panel created
	public JPanel getExpressionsPanel() {
        return expressionPanel;
    }
	
	private static void updateLowerFace(String lowerFaceAttribute, Double lowerFaceVal) {
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.smile.name() , 
				lowerFaceAttribute.equals("Smile") ? lowerFaceVal : 0.0);
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.clench.name(), 
				lowerFaceAttribute.equals("Clench") ? lowerFaceVal : 0.0);
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.leftSmirk.name(), 
				lowerFaceAttribute.equals("Smirk Left") ? lowerFaceVal : 0.0);
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.rightSmirk.name(), 
				lowerFaceAttribute.equals("Smirk Right") ? lowerFaceVal : 0.0);
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.laugh.name(), 
				lowerFaceAttribute.equals("Laugh") ? lowerFaceVal : 0.0);
	}

	private static void updateUpperFace(String upperFaceAttribute, Double upperFaceVal) {
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.raiseBrow.name(),  
				upperFaceAttribute.equals("Raise Brow") ? upperFaceVal : 0.0);
		ServerCommonData.getInstance().getMessage().setAbstractExpression(
				AbstractExpression.furrowBrow.name(),  
				upperFaceAttribute.equals("Furrow Brow") ? upperFaceVal : 0.0);		
	}

	private static void updateEye(String eyeAttribute, Boolean eyeVal) {
		ServerCommonData.getInstance().getMessage().setConcreteExpression(
				ConcreteExpression.blink.name(), eyeAttribute.equals("Blink") ? eyeVal : false);
		ServerCommonData.getInstance().getMessage().setConcreteExpression(
				ConcreteExpression.leftWink.name(), 
				eyeAttribute.equals("Wink Left") ? eyeVal : false);
		ServerCommonData.getInstance().getMessage().setConcreteExpression(
				ConcreteExpression.rightWink.name(), 
				eyeAttribute.equals("Wink Right") ? eyeVal : false);
		ServerCommonData.getInstance().getMessage().setConcreteExpression(
				ConcreteExpression.lookingLeft.name(), 
				eyeAttribute.equals("Look Left") ? eyeVal : false);
		ServerCommonData.getInstance().getMessage().setConcreteExpression(
				ConcreteExpression.lookingRight.name(), 
				eyeAttribute.equals("Look Right") ? eyeVal : false);
	}
}