import { useState } from "react";
import { useNavigate } from "react-router-dom";

const IncomeForm = ({listOfIncomeSources}) => {

    const navigate = useNavigate();

    const [stateIncome, setSateIncome] = useState(
        {
            entryType : "INCOME",
            timeOfCreation : null,
            description : null,
            incomeSourceId : null,
            preTaxAmount : 0,
            postTaxAmount : 0
        }
    );

    const handleFormSubmit = (event)=>{
        event.preventDefault();

        let copiedIncome = {...stateIncome};
        copiedIncome.timeOfCreation = new Date();

        setSateIncome(copiedIncome);

        setSateIncome(
        {
            entryType : "INCOME",
            timeOfCreation : null,
            description : null,
            incomeSourceId : null,
            preTaxAmount : 0,
            postTaxAmount : 0
        })
        
    };

    const handleChange = (event)=>{
        let propertyName = event.target.name;

        let copiedIncome = {...stateIncome};
        copiedIncome[propertyName] = event.target.value;

        setSateIncome(copiedIncome);
    };

    const generateOptions = ()=>{
        return listOfIncomeSources.map((incomeSource)=>{
            return <option  key={incomeSource.id} value={incomeSource.id}>{incomeSource.name}</option>
        });
    };

    return ( 
        <form id="income-form" onSubmit={handleFormSubmit}>
            <p>(*) Required fields</p>
            <label htmlFor="income-sources-select">Choose a source of income * </label>
            <select required name="incomeSourceId" id="income-sources-select" onChange={handleChange}>
                <option key="disabled-selected-income-sources" value="" disabled selected>--Please choose an option--</option>
                {generateOptions()}
            </select>
            <label htmlFor="description-input-box">Write a description of the Income Entry </label>
            <textarea onChange={handleChange} name="description" type="text" maxLength={255} id="description-input-box" autoComplete="on" placeholder="Enter a brief description of anything to note about this entry"/>
            <label htmlFor="preTax-Input">Enter the Pre-tax Income</label>
            <input required onChange={handleChange} name="preTaxAmount" type="number" id="preTax-Input" placeholder="Write the Pre-tax amount here" autoComplete="on"/>
            <label htmlFor="postTax-Input">Enter the Post-tax Income</label>
            <input required onChange={handleChange} name="postTaxAmount" type="number" id="postTax-Input" placeholder="Write the Post-tax amount here" autoComplete="on"/>

            timeOfCreation - use current time or past time
            <button type="submit">Add the Entry</button>
        </form>
     );
}
 
export default IncomeForm;