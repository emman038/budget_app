import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { FaPencilAlt } from "react-icons/fa";
import { ImBin } from "react-icons/im";
import { RxUpdate } from "react-icons/rx";

const EditBudgetForm = ({ entryToEdit, listOfExpenseCategories, deleteEntry, modifyEntry }) => {
    const navigate = useNavigate();

    const [stateBudget, setStateBudget] = useState(
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

        let copiedBudget = { ...stateBudget };
        copiedBudget[propertyName] = event.target.value;

        setStateBudget(copiedBudget);
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
        return stateBudget.description ? stateBudget.description : "There are no notes for this entry. Click the edit button to add some notes.";
    };

    const generateDescriptionTextFoEditable = () => {
        return stateBudget.description ? stateBudget.description : "";
    };

    const toggleEditMode = () => {
        setIsEditable(!isEditable);
    };

    const handleDelete = () => {
        deleteEntry(stateBudget.id, "budgets");

        setStateBudget(
            {
                id: "",
                entryType: "BUDGET",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Budget was successfully deleted.");

        navigate("/");
    };

    const handleModify = () => {
        modifyEntry(stateBudget, "budgets");

        setStateBudget(
            {
                id: "",
                entryType: "BUDGET",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Budget was successfully modified.");

        navigate("/");
    };

    const generateDisabledForm = () => {
        return (
            <form id="disabledBudgetForm">
                <h2>Budget Entry</h2>
                <button onClick={toggleEditMode}><FaPencilAlt /> Edit this Entry</button>
                <button onClick={handleDelete}><ImBin /> Delete this Entry</button>
                <label htmlFor="expenseCategoriesSelect">Category of the Budget:</label>
                <select disabled required name="expenseCategoryId" id="expenseCategoriesSelect" defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedExpenseCategories" value="" disabled>--Please choose an option--</option>
                    <option key={entryToEdit.expenseCategory.id} value={entryToEdit.expenseCategory.id}>{entryToEdit.expenseCategory.name}</option>
                </select>

                <label htmlFor="descriptionInputBox">A brief description of the Budget Entry:</label>
                <textarea disabled value={generateDescriptionTextForDisabled()} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" />

                <label htmlFor="amountInput">Amount:</label>
                <input disabled value={stateBudget.amount} name="amount" type="number" id="amountInput" autoComplete="on" />
            </form>
        );
    };

    const generateEditableForm = () => {
        return (
            <form id="budgetForm">
                <h2>Budget Entry</h2>
                <p>(*) Required fields</p>
                <label htmlFor="expenseCategoriesSelect">Choose a category for this budget * </label>
                <select required name="expenseCategoryId" id="expenseCategoriesSelect" onChange={handleChange} defaultValue={generateDefaultValue()}>
                    <option key="disabledSelectedExpenseCategories" value="" disabled>--Please choose an option--</option>
                    {generateOptions()}
                </select>

                <label htmlFor="descriptionInputBox">Write a description of the Budget Entry </label>
                <textarea value={generateDescriptionTextFoEditable()} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

                <label htmlFor="amountInput">Enter the Budget amount *</label>
                <input value={stateBudget.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the budget amount here" autoComplete="on" />

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

export default EditBudgetForm;