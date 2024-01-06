import ActualSavingForm from "./ActualSavingForm";
import BudgetForm from "./BudgetForm";
import ExpenseForm from "./ExpenseForm";
import IncomeForm from "./IncomeForm";
import SavingGoalForm from "./SavingGoalForm";

import { useState } from "react";

const AddEntryForm = ({listOfClassifications, postEntry, entryToAdd, setEntryToAdd}) => {

    const [stateSelectedEntry, setStateSelectedEntry] = useState("income");

    const handleEntrySelection = (event)=>{
        setStateSelectedEntry(event.target.value)
    };

    const handleFormSubmit = (event)=>{
        event.preventDefault();
        setEntryToAdd(stateSelectedEntry);
    };

    if (!entryToAdd){
        return (
            <form id="selectEntryToAddForm" onSubmit={handleFormSubmit}>
                <p>Select the type of Entry you'd like to add</p>
                <label htmlFor="selectIncome">Income</label>
                <input id="selectIncome" type="radio" name="selectEntry" checked={stateSelectedEntry === "income"} value="income" onChange={handleEntrySelection} />
                <label htmlFor="selectExpense">Expense</label>
                <input id="selectExpense" type="radio" name="selectEntry" checked={stateSelectedEntry === "expense"} value="expense" onChange={handleEntrySelection} />
                <label htmlFor="selectBudget">Budget</label>
                <input id="selectBudget" type="radio" name="selectEntry" checked={stateSelectedEntry === "budget"} value="budget" onChange={handleEntrySelection} />
                <label htmlFor="selectActualSavings">Actual Savings</label>
                <input id="selectActualSavings" type="radio" name="selectEntry" checked={stateSelectedEntry === "actualSavings"} value="actualSavings" onChange={handleEntrySelection} />
                <label htmlFor="selectSavingsGoal">Savings Goal</label>
                <input id="selectSavingsGoal" type="radio" name="selectEntry" checked={stateSelectedEntry === "SavingsGoal"} value="SavingsGoal" onChange={handleEntrySelection} />
                <button type="submit">Click to fill the form</button>
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