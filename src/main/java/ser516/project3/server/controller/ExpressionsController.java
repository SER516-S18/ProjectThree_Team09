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

public class ExpressionsController implements ControllerInterface{
  private ExpressionsModel expressionsModel;
  private ExpressionsView expressionsView;

  public ExpressionsController(ExpressionsModel expressionsModel, ExpressionsView expressionsView) {
    this.expressionsModel = expressionsModel;
    this.expressionsView = expressionsView;
  }

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

  class LowerFaceComboListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox comboBox = (JComboBox) e.getSource();
      expressionsModel.setLowerFaceItem(String.valueOf(comboBox.getSelectedItem()));
      updateLowerFace(expressionsModel.getLowerFaceItem(), expressionsModel.getLowerFaceValue());
    }
  }

  class UpperFaceComboListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox comboBox = (JComboBox) e.getSource();
      expressionsModel.setUpperFaceItem(String.valueOf(comboBox.getSelectedItem()));
      updateUpperFace(expressionsModel.getUpperFaceItem(), expressionsModel.getUpperFaceValue());
    }
  }

  class EyeComboListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox comboBox = (JComboBox) e.getSource();
      expressionsModel.setEyeItem(String.valueOf(comboBox.getSelectedItem()));
      updateEye(expressionsModel.getEyeItem(), expressionsModel.getEyeValue());
    }
  }

  class LowerFaceSpinnerChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      JSpinner jSpinner = (JSpinner) e.getSource();
      expressionsModel.setLowerFaceValue((double)jSpinner.getValue());
      updateLowerFace(expressionsModel.getLowerFaceItem(), expressionsModel.getLowerFaceValue());
    }
  }

  class UpperFaceSpinnerChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      JSpinner jSpinner = (JSpinner) e.getSource();
      expressionsModel.setUpperFaceValue((double)jSpinner.getValue());
      updateUpperFace(expressionsModel.getUpperFaceItem(), expressionsModel.getUpperFaceValue());
    }
  }

  class ActivateToggleButtonItemListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent ev) {
      JToggleButton jToggleButton = (JToggleButton) ev.getSource();
      expressionsModel.setEyeValue(jToggleButton.isSelected());
      updateEye(expressionsModel.getEyeItem(), expressionsModel.getEyeValue());
    }
  }

  class EyeCheckBoxListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // To be implemented
      // AbstractButton abstractButton = (AbstractButton) e.getSource();
      // updateEyeAutoReset(abstractButton.getModel().isSelected());
    }
  }

  private static void updateLowerFace(String lowerFaceAttribute, Double lowerFaceVal) {
	  
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

  private static void updateUpperFace(String upperFaceAttribute, Double upperFaceVal) {
	  ServerCommonData.getInstance().getMessage().setSelectionFlag("upperFace", upperFaceAttribute);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.raiseBrow.name(),
        upperFaceAttribute.equals("Raise Brow") ? upperFaceVal : 0.0);
    ServerCommonData.getInstance().getMessage().setAbstractExpression(
        MessageModel.AbstractExpression.furrowBrow.name(),
        upperFaceAttribute.equals("Furrow Brow") ? upperFaceVal : 0.0);
  }

  private static void updateEye(String eyeAttribute, Boolean eyeVal) {
	  ServerCommonData.getInstance().getMessage().setSelectionFlag("eye", eyeAttribute);
    ServerCommonData.getInstance().getMessage().setConcreteExpression(
        MessageModel.ConcreteExpression.blink.name(), eyeAttribute.equals("Blink") ? eyeVal : false);
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
  }

  public ExpressionsView getExpressionsView() {
    return expressionsView;
  }
}
