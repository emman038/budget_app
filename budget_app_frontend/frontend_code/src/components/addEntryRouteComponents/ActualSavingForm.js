import { useState } from "react";
import { useNavigate } from "react-router-dom";

const ActualSavingForm = ({listOfSavingCategories, postEntry}) => {

    const navigate = useNavigate();

    const [stateActualSaving, setStateActualSaving] = useState(
        {
            entryType: "ACTUAL_SAVING",
            description: "",
            savingCategoryId: null,
            amount: ""
        }
    );

    const handleFormSubmit = (event) => {
        event.preventDefault();

        console.log(stateActualSaving);

        postEntry(stateActualSaving, "actual-savings");

        setStateActualSaving(
            {
                entryType: "ACTUAL_SAVING",
                description: "",
                expenseCategoryId: null,
                amount: ""
            })

        alert("Actual Savings was successfully added.");

        navigate("/");
    };

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

    return (
        <form id="actualSavingForm" onSubmit={handleFormSubmit}>
            <h2>Actual Savings Entry</h2>
            <p>(*) Required fields</p>
            <label htmlFor="savingCategoriesSelect">Choose a source of income * </label>
            <select required name="savingCategoryId" id="savingCategoriesSelect" onChange={handleChange} defaultValue="">
                <option key="disabledSelectedSavingCategories" value="" disabled>--Please choose an option--</option>
                {generateOptions()}
            </select>

            <label htmlFor="descriptionInputBox">Write a description of the Actual Savings Entry </label>
            <textarea value={stateActualSaving.description} onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />

            <label htmlFor="amountInput">Enter the Actual Savings amount *</label>
            <input value={stateActualSaving.amount} required onChange={handleChange} name="amount" type="number" id="amountInput" placeholder="Write the actual savings amount here" autoComplete="on" />
            
            <button type="submit">Add the Entry</button>
        </form>
    );
}

export default ActualSavingForm;