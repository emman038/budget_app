import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaPencilAlt } from "react-icons/fa";
import { ImBin } from "react-icons/im";
import { RxUpdate } from "react-icons/rx";

const EditExpenseForm = ({ entryToEdit, listOfExpenseCategories, deleteEntry, modifyEntry }) => {
    const navigate = useNavigate();

    const [stateExpense, setStateExpense] = useState(
        {
            id: entryToEdit.id,
            entryType: entryToEdit.entryType,
            description: entryToEdit.description,
            expenseCategoryId: entryToEdit.expenseCategory.id,
            amount: entryToEdit.amount
        }
    );

    const [isEditable, setIsEditable] = useState(false);

    const handleChange = (event) => {
        let propertyName = event.target.name;

        let copiedExpense = { ...stateExpense };
        copiedExpense[propertyName] = event.target.value;

        setStateExpense(copiedExpense);
    };

    const generateOptions = () => {
        return listOfExpenseCategories.map((expenseCategory) => {
            return <option key={expenseCategory.id} value={expenseCategory.id}>{expenseCategory.name}</option>
        });
    };

    const generateDefaultValue = () => {
        return entryToEdit.expenseCategory.id;
    };

    const generateDescriptionTextForDisabled = () => {
        return stateExpense.description ? stateExpense.description : "There are no notes for this entry. Click the edit button to add some notes.";
    };

    const generateDescriptionTextFoEditable = () => {
        return stateExpense.description ? stateExpense.description : "";
    };

    const toggleEditMode = () => {
        setIsEditable(!isEditable);
    };

    const handleDelete = () => {
        deleteEntry(stateExpense.id, "expenses");

        setStateExpense(
            {
                id: "",
                entryType: "EXPENSE",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Expense was successfully deleted.");

        navigate("/");
    };

    const handleModify = () => {
        modifyEntry(stateExpense, "expenses");

        setStateExpense(
            {
                id: "",
                entryType: "EXPENSE",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Expense was successfully modified.");

        navigate("/");
    };

    const generateDisabledForm = () => {
        return (
            <form id="disabledExpenseForm">
                <h2>Expense Entry</h2>
                <button onClick={toggleEditMode}><FaPencilAlt /> Edit this Entry</button>
                <button onClick={handleDelete}><ImBin /> Delete this Entry</button>
                <label htmlFor="expenseCategoriesSelect">Category fo the Expense:</label>
                <select disabled required name="expenseCategoryId" id="expenseCategoriesSelect" defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedExpenseCategories" value="" disabled>--Please choose an option--</option>
                    <option key={entryToEdit.expenseCategory.id} value={entryToEdit.expenseCategory.id}>{entryToEdit.expenseCategory.name}</option>
                </select>

                <label htmlFor="descriptionInputBox">A brief description of the Expense Entry:</label>
                <textarea disabled value={generateDescriptionTextForDisabled()} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" />

                <label htmlFor="amountInput">Pre-tax Income:</label>
                <input disabled value={stateExpense.amount} name="amount" type="number" id="amountInput" autoComplete="on" />
            </form>
        );
    };

    const generateEditableForm = () => {
        return (
            <form id="incomeForm">
                <h2>Expense Entry</h2>
                <p>(*) Required fields</p>
                <label htmlFor="expenseCategoriesSelect">Choose an Expense Category * </label>
                <select required name="expenseCategoryId" id="expenseCategoriesSelect" onChange={handleChange} defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedExpenseCategories" value="" disabled>--Please choose an option--</option>
                    {generateOptions()}
                </select>

                <label htmlFor="descriptionInputBox">Write a description of the Expense Entry </label>
                <textarea value={generateDescriptionTextFoEditable()} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

                <label htmlFor="amountInput">Enter the Expense amount *</label>
                <input value={stateExpense.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the expense amount here" autoComplete="on" />

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

export default EditExpenseForm;