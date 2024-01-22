import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaPencilAlt } from "react-icons/fa";
import { ImBin } from "react-icons/im";
import { RxUpdate } from "react-icons/rx";

const EditActualSavingForm = ({entryToEdit, listOfSavingCategories, deleteEntry, modifyEntry}) => {
    const navigate = useNavigate();

    const [stateActualSaving, setStateActualSaving] = useState(
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

        let copiedActualSaving = { ...stateActualSaving };
        copiedActualSaving[propertyName] = event.target.value;

        setStateActualSaving(copiedActualSaving);
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
        return stateActualSaving.description ? stateActualSaving.description : "There are no notes for this entry. Click the edit button to add some notes.";
    };

    const generateDescriptionTextForEditable = () => {
        return stateActualSaving.description ? stateActualSaving.description : "";
    };

    const toggleEditMode = () => {
        setIsEditable(!isEditable);
    };

    const handleDelete = () => {
        deleteEntry(stateActualSaving.id, "actual-savings");

        setStateActualSaving(
            {
                id: "",
                entryType: "ACTUAL_SAVING",
                description: "",
                savingCategoryId: "",
                amount: ""
            })

        alert("Actual Savings was successfully deleted.");

        navigate("/");
    };

    const handleModify = () => {
        modifyEntry(stateActualSaving, "actual-savings");

        setStateActualSaving(
            {
                id: "",
                entryType: "ACTUAL_SAVING",
                description: "",
                savingCategoryId: "",
                amount: ""
            })

        alert("Actual Savings was successfully modified.");

        navigate("/");
    };

    const generateDisabledForm = () => {
        return (
            <form id="disabledActualSavingForm">
                <h2>Actual Savings Entry</h2>
                <button onClick={toggleEditMode}><FaPencilAlt /> Edit this Entry</button>
                <button onClick={handleDelete}><ImBin /> Delete this Entry</button>
                <label htmlFor="savingCategoriesSelect">Category for this entry:</label>
                <select disabled required name="savingCategoryId" id="savingsCategoriesSelect" defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedSavingsCategories" value="" disabled>--Please choose an option--</option>
                    <option key={entryToEdit.savingCategory.id} value={entryToEdit.savingCategory.id}>{entryToEdit.savingCategory.name}</option>
                </select>

                <label htmlFor="descriptionInputBox">A brief description of the Actual Savings Entry:</label>
                <textarea disabled value={generateDescriptionTextForDisabled()} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" />

                <label htmlFor="amountInput">Amount:</label>
                <input disabled value={stateActualSaving.amount} name="amount" type="number" id="amountInput" autoComplete="on" />
            </form>
        );
    };

    const generateEditableForm = () => {
        return (
            <form id="actualSavingForm">
                <h2>Actual Savings Entry</h2>
                <p>(*) Required fields</p>
                <label htmlFor="savingCategoriesSelect">Choose a category for this entry * </label>
                <select required name="savingCategoryId" id="savingCategoriesSelect" onChange={handleChange} defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedSavingCategories" value="" disabled>--Please choose an option--</option>
                    {generateOptions()}
                </select>

                <label htmlFor="descriptionInputBox">Write a description for this Entry </label>
                <textarea value={generateDescriptionTextForEditable()} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

                <label htmlFor="amountInput">Enter the Actual Savings amount *</label>
                <input value={stateActualSaving.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the Pre-tax amount here" autoComplete="on" />
                
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
 
export default EditActualSavingForm;