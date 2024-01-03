import ActualSavingForm from "./ActualSavingForm";
import BudgetForm from "./BudgetForm";
import ExpenseForm from "./ExpenseForm";
import IncomeForm from "./IncomeForm";
import SavingGoalForm from "./SavingGoalForm";

const AddEntryForm = ({listOfClassifications}) => {
    
    if (!listOfClassifications){
        return <p>Page Loading...</p>
    }

    return ( 
        <main>
            <p>AddEntryForm</p>
            <IncomeForm listOfIncomeSources={listOfClassifications.incomeSources}/>
            <ExpenseForm />
            <BudgetForm />
            <ActualSavingForm/>
            <SavingGoalForm />
        </main>
     );
}
 
export default AddEntryForm;