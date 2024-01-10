import { useState } from "react";
import { useNavigate } from "react-router-dom";

const EditIncomeForm = ({ entryToEdit, listOfIncomeSources, postEntry, deleteEntry }) => {
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

    const handleFormSubmit = (event) => {
        event.preventDefault();

        postEntry(stateIncome, "incomes");

        setStateIncome(
            {
                id: "",
                entryType: "INCOME",
                description: "",
                incomeSourceId: "",
                preTaxAmount: "",
                postTaxAmount: ""
            })

        alert("Income was successfully added.");

        navigate("/");
    };

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

    const generateDescriptionText = () => {
        return stateIncome.description ? stateIncome.description : "There are no notes for this entry. Click the edit button to add some notes."
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

    const generateDisabledForm = () => {
        return (
            <form id="disabledIncomeForm">
                <h2>Income Entry</h2>
                <label htmlFor="incomeSourcesSelect">Source of income:</label>
                <select disabled required name="incomeSourceId" id="incomeSourcesSelect" defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedIncomeSources" value="" disabled>--Please choose an option--</option>
                    <option key={entryToEdit.incomeSource.id} value={entryToEdit.incomeSource.id}>{entryToEdit.incomeSource.name}</option>
                </select>

                <label htmlFor="descriptionInputBox">A brief description of the Income Entry:</label>
                <textarea disabled value={generateDescriptionText()} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" />

                <label htmlFor="preTaxInput">Pre-tax Income:</label>
                <input disabled value={stateIncome.preTaxAmount} name="preTaxAmount" type="number" id="preTaxInput" autoComplete="on" />
                <label htmlFor="postTaxInput">Post-tax Income:</label>
                <input disabled value={stateIncome.postTaxAmount} name="postTaxAmount" type="number" id="postTaxInput" autoComplete="on" />

                <button onClick={toggleEditMode}>Edit this Entry</button>
                <button onClick={handleDelete}>Delete this Entry</button>
            </form>
        );
    };

    const generateEditableForm = () => {
        return (
            <section id="incomeForm" onSubmit={handleFormSubmit}>
                <h2>Income Entry</h2>
                <p>(*) Required fields</p>
                <label htmlFor="incomeSourcesSelect">Choose a source of income * </label>
                <select required name="incomeSourceId" id="incomeSourcesSelect" onChange={handleChange} defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedIncomeSources" value="" disabled>--Please choose an option--</option>
                    {generateOptions()}
                </select>

                <label htmlFor="descriptionInputBox">Write a description of the Income Entry </label>
                <textarea value={stateIncome.description} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

                <label htmlFor="preTaxInput">Enter the Pre-tax Income *</label>
                <input value={stateIncome.preTaxAmount} required onChange={handleChange} name="preTaxAmount" type="number" id="preTaxInput" placeholder="Write the Pre-tax amount here" autoComplete="on" />
                <label htmlFor="postTaxInput">Enter the Post-tax Income *</label>
                <input value={stateIncome.postTaxAmount} required onChange={handleChange} name="postTaxAmount" type="number" id="postTaxInput" placeholder="Write the Post-tax amount here" autoComplete="on" />

                <button type="submit">Add the Entry</button>
            </section>
        );
    };

    return (
        <>
            {isEditable ? generateEditableForm() : generateDisabledForm()}
        </>
    );
}

export default EditIncomeForm;