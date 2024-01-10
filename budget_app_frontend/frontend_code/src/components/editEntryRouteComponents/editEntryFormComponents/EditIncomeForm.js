import { useState } from "react";
import { useNavigate } from "react-router-dom";

const EditIncomeForm = ({entryToEdit, listOfIncomeSources, postEntry}) => {
    const navigate = useNavigate();

    const [stateIncome, setSateIncome] = useState(
        {
            entryType: entryToEdit.entryType,
            description: entryToEdit.description,
            incomeSourceId: entryToEdit.incomeSource,
            preTaxAmount: entryToEdit.preTaxAmount,
            postTaxAmount: entryToEdit.postTaxAmount
        }
    );

    const handleFormSubmit = (event) => {
        event.preventDefault();

        postEntry(stateIncome, "incomes");

        setSateIncome(
            {
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

        setSateIncome(copiedIncome);
    };

    const generateOptions = () => {
        return listOfIncomeSources.map((incomeSource) => {
            return <option key={incomeSource.id} value={incomeSource.id}>{incomeSource.name}</option>
        });
    };

    const generateDefaultValue = ()=>{
        return entryToEdit.incomeSource;
    };

    return (
        <form id="incomeForm" onSubmit={handleFormSubmit}>
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
        </form>
    );
}
 
export default EditIncomeForm;