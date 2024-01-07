import { useState } from "react";
import { useNavigate } from "react-router-dom";

const IncomeForm = ({ listOfIncomeSources, postEntry }) => {

    const navigate = useNavigate();

    const [stateIncome, setSateIncome] = useState(
        {
            entryType: "INCOME",
            timeOfCreation: null,
            description: null,
            incomeSourceId: null,
            preTaxAmount: 0,
            postTaxAmount: 0
        }
    );

    const [stateSelectedTimeOfCreation, setStateSelectedTimeOfCreation] = useState("currentTime");

    const handleTimeOfCreationSelection = (event) => {
        setStateSelectedTimeOfCreation(event.target.value)
    };

    const handleFormSubmit = (event) => {
        event.preventDefault();

        let copiedIncome = { ...stateIncome };

        let timePropertyName = "timeOfCreation";

        if (stateSelectedTimeOfCreation=== "currentTime"){
            copiedIncome[timePropertyName] = new Date().toISOString().slice(0, 19);
        } else {
            copiedIncome[timePropertyName] = event.target.elements.namedItem("past-date-time-input").value + ":00";
        };

        setSateIncome(copiedIncome);

        postEntry(stateIncome, "incomes");

        setSateIncome(
            {
                entryType: "INCOME",
                timeOfCreation: null,
                description: null,
                incomeSourceId: null,
                preTaxAmount: 0,
                postTaxAmount: 0
            })
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

    return (
        <form id="incomeForm" onSubmit={handleFormSubmit}>
            <p>(*) Required fields</p>
            <label htmlFor="incomeSourcesSelect">Choose a source of income * </label>
            <select required name="incomeSourceId" id="incomeSourcesSelect" onChange={handleChange} defaultValue="">
                <option key="disabledSelectedIncomeSources" value="" disabled>--Please choose an option--</option>
                {generateOptions()}
            </select>

            <label htmlFor="descriptionInputBox">Write a description of the Income Entry </label>
            <textarea onChange={handleChange} name="description" type="text" maxLength={255} id="descriptionInputBox" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry" />
            
            <label htmlFor="preTaxInput">Enter the Pre-tax Income *</label>
            <input required onChange={handleChange} name="preTaxAmount" type="number" id="preTaxInput" placeholder="Write the Pre-tax amount here" autoComplete="on" />
            <label htmlFor="postTaxInput">Enter the Post-tax Income *</label>
            <input required onChange={handleChange} name="postTaxAmount" type="number" id="postTaxInput" placeholder="Write the Post-tax amount here" autoComplete="on" />

            <button type="submit">Add the Entry</button>
        </form>
    );
}

export default IncomeForm;