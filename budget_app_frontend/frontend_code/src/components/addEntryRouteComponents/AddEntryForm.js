import ActualSavingForm from "./ActualSavingForm";
import BudgetForm from "./BudgetForm";
import ExpenseForm from "./ExpenseForm";
import IncomeForm from "./IncomeForm";
import SavingGoalForm from "./SavingGoalForm";

const AddEntryForm = () => {
    return ( 
        <>
            <p>AddEntryForm</p>
            <IncomeForm />
            <ExpenseForm />
            <BudgetForm />
            <ActualSavingForm />
            <SavingGoalForm />
        </>
     );
}
 
export default AddEntryForm;