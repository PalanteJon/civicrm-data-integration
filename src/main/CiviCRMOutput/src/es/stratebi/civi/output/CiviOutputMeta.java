package es.stratebi.civi.output;

import org.eclipse.swt.widgets.Shell;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.core.row.ValueMeta;
import org.pentaho.di.core.row.ValueMetaInterface;
import org.pentaho.di.core.variables.VariableSpace;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepDialogInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;

import es.stratebi.civi.CiviMeta;

public class CiviOutputMeta extends CiviMeta implements StepMetaInterface {

  public CiviOutputMeta() {
    super();
  }

  public Object clone() {
    return super.clone();
  }

  public StepDialogInterface getDialog(Shell shell, StepMetaInterface meta, TransMeta transMeta, String name) {
    return new CiviOutputDialog(shell, meta, transMeta, name);
  }

  public StepInterface getStep(StepMeta stepMeta, StepDataInterface stepDataInterface, int cnr, TransMeta transMeta, Trans disp) {
    return new CiviOutputStep(stepMeta, stepDataInterface, cnr, transMeta, disp);
  }

  public StepDataInterface getStepData() {
    return new CiviOutputData();
  }
  
  public void getFields(RowMetaInterface r, String origin, RowMetaInterface[] info, StepMeta nextStep, VariableSpace space) {
//    super.getFields(r, origin, info, nextStep, space);
    if (civiCrmResultField != null && !civiCrmResultField.equals("")) {
      ValueMetaInterface v = new ValueMeta(civiCrmResultField, ValueMetaInterface.TYPE_STRING);
      v.setOrigin(origin);
      r.addValueMeta(v);
    }
  }
}
