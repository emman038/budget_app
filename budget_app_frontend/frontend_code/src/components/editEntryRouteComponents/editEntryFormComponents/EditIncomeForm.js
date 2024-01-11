import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaPencilAlt } from "react-icons/fa";
import { ImBin } from "react-icons/im";
import { RxUpdate } from "react-icons/rx";


const EditIncomeForm = ({ entryToEdit, listOfIncomeSources, deleteEntry, modifyEntry }) => {
    const navigate = useNavigate();

    const [stateIncome, setStateIncome] = useState(
        {
            id: entryToEdit.id,
            entryType: entryToEdit.entryType,
            description: entryToEdit.description,
            incomeSourceId: entryToEdit.incomeSource.id,
            preTaxAmount: entryToEdit.preTaxAmount,
            postTaxAmount: entryToEdit.postTaxAmount
        }
    );

    const [isEditable, setIsEditable] = useState(false);

    const handleChange = (event) => {
        let propertyName = event.target.name;

        let copiedIncome = { ...stateIncome };
        copiedIncome[propertyName] = event.target.value;

        setStateIncome(copiedIncome);
    };

    const generateOptions = () => {
        return listOfIncomeSources.map((incomeSource) => {
            return <option key={incomeSource.id} value={incomeSource.id}>{incomeSource.name}</option>
        });
    };

    const generateDefaultValue = () => {
        return entryToEdit.incomeSource.id;
    };

    const generateDescriptionTextForDisabled = () => {
        return stateIncome.description ? stateIncome.description : "There are no notes for this entry. Click the edit button to add some notes.";
    };

    const generateDescriptionTextFoEditable = () => {
        return stateIncome.description ? stateIncome.description : "";
    };

    const toggleEditMode = () => {
        setIsEditable(!isEditable);
    };

    const handleDelete = () => {
        deleteEntry(stateIncome.id, "incomes");

        setStateIncome(
            {
                id: "",
                entryType: "INCOME",
                description: "",
                incomeSourceId: "",
                preTaxAmount: "",
                postTaxAmount: ""
            })

        alert("Income was successfully deleted.");

        navigate("/");
    };

    const handleModify = () => {
        modifyEntry(stateIncome, "incomes");

        setStateIncome(
            {
                id: "",
                entryType: "INCOME",
                description: "",
                incomeSourceId: "",
                preTaxAmount: "",
                postTaxAmount: ""
            })

        alert("Income was successfully modified.");

        navigate("/");
    };

    const generateDisabledForm = () => {
        return (
            <form id="disabledIncomeForm">
                <h2>Income Entry</h2>
                <button onClick={toggleEditMode}><FaPencilAlt /> Edit this Entry</button>
                <button onClick={handleDelete}><ImBin /> Delete this Entry</button>
                <label htmlFor="incomeSourcesSelect">Source of income:</label>
                <select disabled required name="incomeSourceId" id="incomeSourcesSelect" defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedIncomeSources" value="" disabled>--Please choose an option--</option>
                    <option key={entryToEdit.incomeSource.id} value={entryToEdit.incomeSource.id}>{entryToEdit.incomeSource.name}</option>
                </select>

                <label htmlFor="descriptionInputBox">A brief description of the Income Entry:</label>
                <textarea disabled value={generateDescriptionTextForDisabled()} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" />

                <label htmlFor="preTaxInput">Pre-tax Income:</label>
                <input disabled value={stateIncome.preTaxAmount} name="preTaxAmount" type="number" id="preTaxInput" autoComplete="on" />
                <label htmlFor="postTaxInput">Post-tax Income:</label>
                <input disabled value={stateIncome.postTaxAmount} name="postTaxAmount" type="number" id="postTaxInput" autoComplete="on" />
            </form>
        );
    };

    const generateEditableForm = () => {
        return (
            <form id="incomeForm">
                <h2>Income Entry</h2>
                <p>(*) Required fields</p>
                <label htmlFor="incomeSourcesSelect">Choose a source of income * </label>
                <select required name="incomeSourceId" id="incomeSourcesSelect" onChange={handleChange} defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedIncomeSources" value="" disabled>--Please choose an option--</option>
                    {generateOptions()}
                </select>

                <label htmlFor="descriptionInputBox">Write a description of the Income Entry </label>
                <textarea value={generateDescriptionTextFoEditable()} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

                <label htmlFor="preTaxInput">Enter the Pre-tax Income *</label>
                <input value={stateIncome.preTaxAmount} required onChange={handleChange} name="preTaxAmount" type="number" id="preTaxInput" placeholder="Write the Pre-tax amount here" autoComplete="on" />
                <label htmlFor="postTaxInput">Enter the Post-tax Income *</label>
                <input value={stateIncome.postTaxAmount} required onChange={handleChange} name="postTaxAmount" type="number" id="postTaxInput" placeholder="Write the Post-tax amount here" autoComplete="on" />

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

export default EditIncomeForm;