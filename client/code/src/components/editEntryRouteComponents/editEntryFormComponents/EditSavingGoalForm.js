import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaPencilAlt } from "react-icons/fa";
import { ImBin } from "react-icons/im";
import { RxUpdate } from "react-icons/rx";


const EditSavingGoalForm = ({entryToEdit, listOfSavingCategories, deleteEntry, modifyEntry}) => {
    const navigate = useNavigate();

    const [stateSavingGoal, setStateSavingGoal] = useState(
        {
            id: entryToEdit.id,
            entryType: entryToEdit.entryType,
            description: entryToEdit.description,
            savingCategoryId: entryToEdit.savingCategory.id,
            amount: entryToEdit.amount
        }
    );

    const [isEditable, setIsEditable] = useState(false);

    const handleChange = (event) => {
        let propertyName = event.target.name;

        let copiedSavingGoal = { ...stateSavingGoal };
        copiedSavingGoal[propertyName] = event.target.value;

        setStateSavingGoal(copiedSavingGoal);
    };

    const generateOptions = () => {
        return listOfSavingCategories.map((savingCategory) => {
            return <option key={savingCategory.id} value={savingCategory.id}>{savingCategory.name}</option>
        });
    };

    const generateDefaultValue = () => {
        return entryToEdit.savingCategory.id;
    };

    const generateDescriptionTextForDisabled = () => {
        return stateSavingGoal.description ? stateSavingGoal.description : "There are no notes for this entry. Click the edit button to add some notes.";
    };

    const generateDescriptionTextForEditable = () => {
        return stateSavingGoal.description ? stateSavingGoal.description : "";
    };

    const toggleEditMode = () => {
        setIsEditable(!isEditable);
    };

    const handleDelete = () => {
        deleteEntry(stateSavingGoal.id, "saving-goals");

        setStateSavingGoal(
            {
                id: "",
                entryType: "SAVING_GOAL",
                description: "",
                savingCategoryId: "",
                amount: ""
            })

        alert("Savings goal was successfully deleted.");

        navigate("/");
    };

    const handleModify = () => {
        modifyEntry(stateSavingGoal, "saving-goals");

        setStateSavingGoal(
            {
                id: "",
                entryType: "SAVING_GOAL",
                description: "",
                savingCategoryId: "",
                amount: ""
            })

        alert("Savings goal was successfully modified.");

        navigate("/");
    };

    const generateDisabledForm = () => {
        return (
            <form id="disabledSavingGoalForm">
                <h2>Savings Goal Entry</h2>
                <button onClick={toggleEditMode}><FaPencilAlt /> Edit this Entry</button>
                <button onClick={handleDelete}><ImBin /> Delete this Entry</button>
                <label htmlFor="savingCategoriesSelect">Category for this entry:</label>
                <select disabled required name="savingCategoryId" id="savingsCategoriesSelect" defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedSavingsCategories" value="" disabled>--Please choose an option--</option>
                    <option key={entryToEdit.savingCategory.id} value={entryToEdit.savingCategory.id}>{entryToEdit.savingCategory.name}</option>
                </select>

                <label htmlFor="descriptionInputBox">A brief description of the Savings Goal Entry:</label>
                <textarea disabled value={generateDescriptionTextForDisabled()} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" />

                <label htmlFor="amountInput">Amount:</label>
                <input disabled value={stateSavingGoal.amount} name="amount" type="number" id="amountInput" autoComplete="on" />
            </form>
        );
    };

    const generateEditableForm = () => {
        return (
            <form id="savingGoalForm">
                <h2>Savings Goal Entry</h2>
                <p>(*) Required fields</p>
                <label htmlFor="savingCategoriesSelect">Choose a category for this entry * </label>
                <select required name="savingCategoryId" id="savingCategoriesSelect" onChange={handleChange} defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedSavingCategories" value="" disabled>--Please choose an option--</option>
                    {generateOptions()}
                </select>

                <label htmlFor="descriptionInputBox">Write a description for this Entry </label>
                <textarea value={generateDescriptionTextForEditable()} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

                <label htmlFor="amountInput">Enter the Savings goal amount *</label>
                <input value={stateSavingGoal.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the Pre-tax amount here" autoComplete="on" />
                
                <button onClick={handleModify}><RxUpdate /> Update this Entry</button>
                <button onClick={handleDelete}><ImBin /> Delete this Entry</button>
            </form>
        );
    };

    return (
        <>
            {isEditable ? generateEditableForm() : generateDisabledForm()}
        </>
    );
}
 
export default EditSavingGoalForm;