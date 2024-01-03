import ActualSavingForm from "./ActualSavingForm";
import BudgetForm from "./BudgetForm";
import ExpenseForm from "./ExpenseForm";
import IncomeForm from "./IncomeForm";
import SavingGoalForm from "./SavingGoalForm";

const AddEntryForm = ({listOfClassifications}) => {
    return ( 
        <main>
            <p>AddEntryForm</p>
            <IncomeForm />
            <ExpenseForm />
            <BudgetForm />
            <ActualSavingForm listOfIncomeSources={listOfClassifications.incomeSources}/>
            <SavingGoalForm />
        </main>
     );
}
 
export default AddEntryForm;