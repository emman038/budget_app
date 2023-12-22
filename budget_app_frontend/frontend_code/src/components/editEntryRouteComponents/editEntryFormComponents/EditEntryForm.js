import EditActualSavingForm from "./EditActualSavingForm";
import EditBudgetForm from "./EditBudgetForm";
import EditExpenseForm from "./EditExpenseForm";
import EditIncomeForm from "./EditIncomeForm";
import EditSavingGoalForm from "./EditSavingGoalForm";

const EditEntryForm = () => {
    return ( 
        <>
            <p>EditEntryForm</p>
            <EditIncomeForm />
            <EditExpenseForm />
            <EditBudgetForm />
            <EditActualSavingForm />
            <EditSavingGoalForm />
        </>
     );
}
 
export default EditEntryForm;