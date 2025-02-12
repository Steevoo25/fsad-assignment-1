package fsd.assignment.assignment1;

import fsd.assignment.assignment1.datamodel.Student;
import fsd.assignment.assignment1.datamodel.StudentData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class EditStudentController {
    //all of the variables declared below correspond with the edit-students.fxml

    @FXML
    private Label yearStudyDisplay;

    @FXML
    private Label mod1Edit;

    @FXML
    private Label mod2Edit;

    @FXML
    private Label mod3Edit;

    @FXML
    private ChoiceBox<String> mod1ChoiceEdit;

    @FXML
    private ChoiceBox<String> mod2ChoiceEdit;

    @FXML
    private ChoiceBox<String> mod3ChoiceEdit;

    //the modChoices variables correspond to the []
    private String mod1S, mod2S, mod3S;

    private final String[] modChoices = {"OOP", "Data Algo", "DS", "Maths", "AI",
            "Adv Programming", "Project"};

    public void initialize() {

        /* add all the modChoices to each ChoiceBox
         */

        mod1ChoiceEdit.getItems().addAll(modChoices);
        mod2ChoiceEdit.getItems().setAll(modChoices);
        mod3ChoiceEdit.getItems().setAll(modChoices);

        //these lines have been given to you includes the setOnAction if a ChoiceBox is selected
        mod1ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod2ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod3ChoiceEdit.setOnAction(this::getChoiceEdit);

    }

    //to ensure that detail pops up to edit
    public void setToEdit(Student stu) {
        /* display the student to be edited details*/

        yearStudyDisplay.setText(stu.getYearOfStudy());
        mod1Edit.setText(stu.getModule1());
        mod2Edit.setText(stu.getModule2());
        mod3Edit.setText(stu.getModule3());

        mod1ChoiceEdit.getSelectionModel().select(stu.getModule1());
        mod2ChoiceEdit.getSelectionModel().select(stu.getModule2());
        mod3ChoiceEdit.getSelectionModel().select(stu.getModule3());

        /* get the new module choices using mod1S, mod2S and mod3S*/

        mod1S = mod1ChoiceEdit.getValue();
        mod2S = mod2ChoiceEdit.getValue();
        mod3S = mod3ChoiceEdit.getValue();
    }

    public Student processEdit(Student stu) {
        /* complete the observableIst statement by getting all students from StudentData
                 to be collected in allStudents
         */
        ObservableList<Student> allStudents = StudentData.getInstance().getStudents();
        /*  get studId and year of study*/
        String studIdS = stu.getStudId();
        String yearStudyS = stu.getYearOfStudy();
        /*  remove the student to be edited from allStudents*/
        allStudents.remove(stu);
        /*  add the student back by creating a new object reference and calling the addStudentData()
         */
        Student changedStu = new Student(studIdS,
                yearStudyS,
                mod1S,
                mod2S,
                mod3S);
        allStudents.add(changedStu);
        //call the addStudentData()
        /*  return the newly edited student back to the Controller class / editStudent()
         */
        return changedStu;
    }

    public void getChoiceEdit(ActionEvent event) {
        /*  complete the 3 if... statements using event
         */
        if (event.getSource().equals(mod1ChoiceEdit)) {
            mod1S = mod1ChoiceEdit.getValue();
        } else if (event.getSource().equals(mod2ChoiceEdit)) {
            mod2S = mod2ChoiceEdit.getValue();
        } else
            mod3S = mod3ChoiceEdit.getValue();
    }
}
