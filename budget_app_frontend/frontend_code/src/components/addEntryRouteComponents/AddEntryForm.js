import ActualSavingForm from "./ActualSavingForm";
import BudgetForm from "./BudgetForm";
import ExpenseForm from "./ExpenseForm";
import IncomeForm from "./IncomeForm";
import SavingGoalForm from "./SavingGoalForm";

const AddEntryForm = ({listOfClassifications, postEntry, entryToAdd}) => {

    if (!entryToAdd){
        return (
            <form id="selectEntryToAddForm">
                <p>Select the type of Entry you want to add</p>
            </form>
        );
    };

    if (!listOfClassifications){
        return <p>Page Loading...</p>
    };

    return ( 
        <main>
            <p>AddEntryForm</p>
            <IncomeForm listOfIncomeSources={listOfClassifications.incomeSources} postEntry={postEntry}/>
            <ExpenseForm />
            <BudgetForm />
            <ActualSavingForm/>
            <SavingGoalForm />
        </main>
     );
}
 
export default AddEntryForm;