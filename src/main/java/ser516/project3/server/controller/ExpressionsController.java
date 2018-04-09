package ser516.project3.server.controller;

import ser516.project3.interfaces.ControllerInterface;
import ser516.project3.model.ExpressionsModel;
import ser516.project3.model.MessageModel;
import ser516.project3.server.view.ExpressionsView;
import ser516.project3.utilities.ServerCommonData;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Class that helps communicate between ExpressionsView and ExpressionsModel.
 * The controller can receive and update data from the ExpressionsView, 
 * and use this data to update the ExpressionsModel.
 * 
 * @author Ser516-Team09
 */
public class ExpressionsController implements ControllerInterface{
  private ExpressionsModel expressionsModel;
  private ExpressionsView expressionsView;

  /**
   * Constructor to set the emotions view and model object
   * @param expressionsModel - ExpressionsModel object
   * @param expressionsView - ExpressionsView object 
   */
  public ExpressionsController(ExpressionsModel expressionsModel, ExpressionsView expressionsView) {
    this.expressionsModel = expressionsModel;
    this.expressionsView = expressionsView;
  }

  /**
   * Method to initialize the expressions view and to add listeners 
   * to all the components in the panel
   */
  @Override
  public void initializeView() {
    expressionsView.initializeView(null);
    expressionsView.addLowerFaceComboListener(new LowerFaceComboListener());
    expressionsView.addUpperFaceComboListener(new UpperFaceComboListener());
    expressionsView.addEyeComboListener(new EyeComboListener());
    expressionsView.addLowerFaceSpinnerChangeListener(new LowerFaceSpinnerChangeListener());
    expressionsView.addUpperFaceSpinnerChangeListener(new UpperFaceSpinnerChangeListener());
    expressionsView.addActivateToggleButtonItemListener(new ActivateToggleButtonItemListener());
    expressionsView.addEyeCheckBoxListener(new EyeCheckBoxListener());
  }
  
  /**
   * Inner class to add action listener to lower face combo box 
   * component in the expressions panel 
   */
  class LowerFaceComboListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox comboBox = (JComboBox) e.getSource();
      expressionsModel.setLowerFaceItem(String.valueOf(comboBox.getSelectedItem()));
      updateLowerFace(expressionsModel.getLowerFaceItem(), expressionsModel.getLowerFaceValue());
    }
  }

  /**
   * Inner class to add action listener to upper face combo box 
   * component in the expressions panel 
   */
  class UpperFaceComboListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox comboBox = (JComboBox) e.getSource();
      expressionsModel.setUpperFaceItem(String.valueOf(comboBox.getSelectedItem()));
      updateUpperFace(expressionsModel.getUpperFaceItem(), expressionsModel.getUpperFaceValue());
    }
  }
  
  /**
   * Inner class to add action listener to eye action combo box 
   * component in the expressions panel 
   */
  class EyeComboListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox comboBox = (JComboBox) e.getSource();
      expressionsModel.setEyeItem(String.valueOf(comboBox.getSelectedItem()));
      updateEye(expressionsModel.getEyeItem(), expressionsModel.getEyeValue());
    }
  }

  /**
   * Inner class to add change listener to lower face action spinner
   * component in the expressions panel 
   */
  class LowerFaceSpinnerChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      JSpinner jSpinner = (JSpinner) e.getSource();
      expressionsModel.setLowerFaceValue((double)jSpinner.getValue());
      updateLowerFace(expressionsModel.getLowerFaceItem(), expressionsModel.getLowerFaceValue());
    }
  }

  /**
   * Inner class to add change listener to upper face action spinner
   * component in the expressions panel 
   */
  class UpperFaceSpinnerChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      JSpinner jSpinner = (JSpinner) e.getSource();
      expressionsModel.setUpperFaceValue((double)jSpinner.getValue());
      updateUpperFace(expressionsModel.getUpperFaceItem(), expressionsModel.getUpperFaceValue());
    }
  }

  /**
   * Inner class to add item listener to eye action toggle button
   * component in the expressions panel 
   */
  class ActivateToggleButtonItemListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent ev) {
      JToggleButton jToggleButton = (JToggleButton) ev.getSource();
      expressionsModel.setEyeValue(jToggleButton.isSelected());
      updateEye(expressionsModel.getEyeItem(), expressionsModel.getEyeValue());
    }
  }

  /**
   * Inner class to add action listener to eye action auto-reset
   * check box in the expressions panel 
   */
  class EyeCheckBoxListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // To be implemented
      // AbstractButton abstractButton = (AbstractButton) e.getSource();
      // updateEyeAutoReset(abstractButton.getModel().isSelected());
    }
  }

  /**
   * Method to update the lower face attributes based on the values 
   * set for each lower face expression in the expression panel
   * 
   * @param lowerFaceAttribute - type of lower face expression
   * @param lowerFaceVal - value set for a particular expression
   */
  private static void updateLowerFace(String lowerFaceAttribute, Double lowerFaceVal){  
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.smile.name() ,
        lowerFaceAttribute.equals("Smile") ? lowerFaceVal : 0.0);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.clench.name(),
        lowerFaceAttribute.equals("Clench") ? lowerFaceVal : 0.0);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.leftSmirk.name(),
        lowerFaceAttribute.equals("Smirk Left") ? lowerFaceVal : 0.0);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.rightSmirk.name(),
        lowerFaceAttribute.equals("Smirk Right") ? lowerFaceVal : 0.0);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.laugh.name(),
        lowerFaceAttribute.equals("Laugh") ? lowerFaceVal : 0.0);

    if (lowerFaceAttribute.equals("Laugh")) {
        ServerCommonData.getInstance().getMessage().setSelectionFlag(
                "lowerFace", MessageModel.AbstractExpression.laugh.name());
    } else if (lowerFaceAttribute.equals("Clench")) {
        ServerCommonData.getInstance().getMessage().setSelectionFlag
                ("lowerFace", MessageModel.AbstractExpression.clench.name());
    } else if (lowerFaceAttribute.equals("Smirk Left")) {
        ServerCommonData.getInstance().getMessage().setSelectionFlag
                ("lowerFace", MessageModel.AbstractExpression.leftSmirk.name());
    } else if (lowerFaceAttribute.equals("Smirk Right")) {
        ServerCommonData.getInstance().getMessage().setSelectionFlag
                ("lowerFace", MessageModel.AbstractExpression.rightSmirk.name());
    } else {
        ServerCommonData.getInstance().getMessage().setSelectionFlag
                ("lowerFace", MessageModel.AbstractExpression.smile.name());
    }

  }

  /**
   * Method to update the upper face attributes based on the values 
   * set for each upper face expression in the expression panel
   * 
   * @param upperFaceAttribute - type of upper face expression
   * @param upperFaceVal - value set for a particular expression
   */
  private static void updateUpperFace(String upperFaceAttribute, Double upperFaceVal) {
	ServerCommonData.getInstance().getMessage().setSelectionFlag("upperFace", 
		upperFaceAttribute);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.raiseBrow.name(),
        upperFaceAttribute.equals("Raise Brow") ? upperFaceVal : 0.0);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.furrowBrow.name(),
        upperFaceAttribute.equals("Furrow Brow") ? upperFaceVal : 0.0);
  }

  /**
   * Method to update the eye related attributes based on the values 
   * set for each upper face expression in the expression panel
   * 
   * @param eyeAttribute - type of eye expression
   * @param eyeVal - value set for a particular eye expression
   */
  private static void updateEye(String eyeAttribute, Boolean eyeVal) {
	ServerCommonData.getInstance().getMessage().setSelectionFlag("eye", eyeAttribute);
    ServerCommonData.getInstance().getMessage().setConcreteExpression(
        MessageModel.ConcreteExpression.blink.name(), 
        eyeAttribute.equals("Blink") ? eyeVal : false);
    ServerCommonData.getInstance().getMessage().setConcreteExpression(
        MessageModel.ConcreteExpression.leftWink.name(),
        eyeAttribute.equals("Wink Left") ? eyeVal : false);
    ServerCommonData.getInstance().getMessage().setConcreteExpression(
        MessageModel.ConcreteExpression.rightWink.name(),
        eyeAttribute.equals("Wink Right") ? eyeVal : false);
    ServerCommonData.getInstance().getMessage().setConcreteExpression(
        MessageModel.ConcreteExpression.lookingLeft.name(),
        eyeAttribute.equals("Look Left") ? eyeVal : false);
    ServerCommonData.getInstance().getMessage().setConcreteExpression(
        MessageModel.ConcreteExpression.lookingRight.name(),
        eyeAttribute.equals("Look Right") ? eyeVal : false);

      if (eyeAttribute.equals("Blink")) {
          ServerCommonData.getInstance().getMessage().setSelectionFlag(
                  "eye", MessageModel.ConcreteExpression.blink.name());
      } else if (eyeAttribute.equals("Wink Left")) {
          ServerCommonData.getInstance().getMessage().setSelectionFlag
                  ("eye", MessageModel.ConcreteExpression.leftWink.name());
      } else if (eyeAttribute.equals("Wink Right")) {
          ServerCommonData.getInstance().getMessage().setSelectionFlag
                  ("eye", MessageModel.ConcreteExpression.rightWink.name());
      } else if (eyeAttribute.equals("Look Left")) {
          ServerCommonData.getInstance().getMessage().setSelectionFlag
                  ("eye", MessageModel.ConcreteExpression.lookingLeft.name());
      } else if (eyeAttribute.equals("Look Right")){
          ServerCommonData.getInstance().getMessage().setSelectionFlag
                  ("eye", MessageModel.ConcreteExpression.lookingRight.name());
      }
  }
  
  /**
   * Method to get the ExpressionsView object
   * @return ExpressionsView object 
   */
  public ExpressionsView getExpressionsView() {
    return expressionsView;
  }
}
