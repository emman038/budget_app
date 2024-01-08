import { useState } from "react";
import { useNavigate } from "react-router-dom";

const BudgetForm = ({listOfExpenseCategories, postEntry}) => {

    const navigate = useNavigate();

    const [stateBudget, setStateBudget] = useState(
        {
            entryType: "BUDGET",
            description: "",
            expenseCategoryId: null,
            amount: ""
        }
    );

    const handleFormSubmit = (event) => {
        event.preventDefault();

        console.log(stateBudget);

        postEntry(stateBudget, "budgets");

        setStateBudget(
            {
                entryType: "BUDGET",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Budget was successfully added.");

        navigate("/");
    };

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

    return (
        <form id="budgetForm" onSubmit={handleFormSubmit}>
            <h3>Budget Entry</h3>
            <p>(*) Required fields</p>
            <label htmlFor="expenseCategoriesSelect">Choose a source of income * </label>
            <select required name="expenseCategoryId" id="expenseCategoriesSelect" onChange={handleChange} defaultValue="">
                <option key="disabledSelectedExpenseCategories" value="" disabled>--Please choose an option--</option>
                {generateOptions()}
            </select>

            <label htmlFor="descriptionInputBox">Write a description of the Budget Entry </label>
            <textarea value={stateBudget.description} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

            <label htmlFor="amountInput">Enter the Budget amount *</label>
            <input value={stateBudget.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the budget amount here" autoComplete="on" />
            
            <button type="submit">Add the Entry</button>
        </form>
    );
}
 
export default BudgetForm;