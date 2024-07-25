import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { TfiSave } from "react-icons/tfi";

const SavingGoalForm = ({listOfSavingCategories, postEntry}) => {

    const navigate = useNavigate();

    const [stateSavingGoal, setStateSavingGoal] = useState(
        {
            entryType: "SAVING_GOAL",
            description: "",
            savingCategoryId: null,
            amount: ""
        }
    );

    const handleFormSubmit = (event) => {
        event.preventDefault();

        postEntry(stateSavingGoal, "saving-goals");

        setStateSavingGoal(
            {
                entryType: "SAVING_GOAL",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Savings goal was successfully added.");

        navigate("/");
    };

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

    return (
        <form id="savingGoalForm" onSubmit={handleFormSubmit}>
            <h2>Savings Goal Entry</h2>
            <p>(*) Required fields</p>
            <label htmlFor="savingCategoriesSelect">Choose a category for this entry * </label>
            <select required name="savingCategoryId" id="savingCategoriesSelect" onChange={handleChange} defaultValue="">
                <option key="disabledSelectedSavingCategories" value="" disabled>--Please choose an option--</option>
                {generateOptions()}
            </select>

            <label htmlFor="descriptionInputBox">Write a description for this Entry </label>
            <textarea value={stateSavingGoal.description} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

            <label htmlFor="amountInput">Enter the Savings goal amount *</label>
            <input value={stateSavingGoal.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the savings goal amount here" autoComplete="on" />
            
            <button type="submit"><TfiSave /> Save Entry</button>
        </form>
    );
}
 
export default SavingGoalForm;