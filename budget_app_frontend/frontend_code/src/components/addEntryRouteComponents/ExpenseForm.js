import { useState } from "react";
import { useNavigate } from "react-router-dom";

const ExpenseForm = ({ listOfExpenseCategories, postEntry }) => {

    const navigate = useNavigate();

    const [stateExpense, setSateExpense] = useState(
        {
            entryType: "EXPENSE",
            description: "",
            expenseCategoryId: null,
            amount: ""
        }
    );

    const handleFormSubmit = (event) => {
        event.preventDefault();

        console.log(stateExpense);

        postEntry(stateExpense, "expenses");

        setSateExpense(
            {
                entryType: "EXPENSE",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Expense was successfully added.");

        navigate("/");
    };

    const handleChange = (event) => {
        let propertyName = event.target.name;

        let copiedExpense = { ...stateExpense };
        copiedExpense[propertyName] = event.target.value;

        setSateExpense(copiedExpense);
    };

    const generateOptions = () => {
        return listOfExpenseCategories.map((expenseCategory) => {
            return <option key={expenseCategory.id} value={expenseCategory.id}>{expenseCategory.name}</option>
        });
    };

    return (
        <form id="expenseForm" onSubmit={handleFormSubmit}>
            <p>(*) Required fields</p>
            <label htmlFor="expenseCategoriesSelect">Choose an Expense Category * </label>
            <select required name="expenseCategoryId" id="expenseCategoriesSelect" onChange={handleChange} defaultValue="">
                <option key="disabledSelectedExpenseCategories" value="" disabled>--Please choose an option--</option>
                {generateOptions()}
            </select>

            <label htmlFor="descriptionInputBox">Write a description of the Expense Entry </label>
            <textarea value={stateExpense.description} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

            <label htmlFor="amountInput">Enter the Expense amount *</label>
            <input value={stateExpense.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the expense amount here" autoComplete="on" />
            
            <button type="submit">Add the Entry</button>
        </form>
    );
}

export default ExpenseForm;