import EditActualSavingForm from "./EditActualSavingForm";
import EditBudgetForm from "./EditBudgetForm";
import EditExpenseForm from "./EditExpenseForm";
import EditIncomeForm from "./EditIncomeForm";
import EditSavingGoalForm from "./EditSavingGoalForm";

import { useNavigate } from "react-router-dom";

const EditEntryForm = ({ entryToEdit, listOfClassifications, postEntry, deleteEntry }) => {

    const navigate = useNavigate();

    const generateForms = () => {
        switch (entryToEdit.entryType) {
            case "INCOME":
                return <EditIncomeForm entryToEdit={entryToEdit} listOfIncomeSources={listOfClassifications.incomeSources} postEntry={postEntry} deleteEntry={deleteEntry}/>
            case "EXPENSE":
                return <EditExpenseForm entryToEdit={entryToEdit} />
            case "BUDGET":
                return <EditBudgetForm entryToEdit={entryToEdit} />
            case "ACTUAL_SAVING":
                <EditActualSavingForm entryToEdit={entryToEdit} />
            case "SAVING_GOAL":
                <EditSavingGoalForm entryToEdit={entryToEdit} />
        };
    };

    const handleClick = ()=>{
        navigate("/select-entry")
    };

    const noEntryElements = ()=>{
        return(
            <>
                <p>Please select an Entry you'd like to edit:</p>
                <button onClick={handleClick}>Select an Entry</button>
            </>
        );
    };

    return (
        <main>
            <p>EditEntryForm</p>
            {entryToEdit ? generateForms() : noEntryElements()}
        </ main>
    );
}

export default EditEntryForm;