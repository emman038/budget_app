import { useState } from "react";
import { useNavigate } from "react-router-dom";

const IncomeForm = ({listOfIncomeSources}) => {

    const navigate = useNavigate();

    const [stateIncome, setSateIncome] = useState(
        {
            entryType : "INCOME",
            timeOfCreation : null,
            description : null,
            incomeSource : null,
            preTaxAmount : 0,
            postTaxAmount : 0
        }
    );

    const handleFormSubmit = (event)=>{
        event.preventDefault();

        let timeOfCreationProperty = "timeOfCreation";

        let copiedIncome = {...stateIncome};
        copiedIncome[timeOfCreationProperty] = new Date();

        
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
            <label htmlFor="income-sources-select">Choose a source of income</label>
            <select name="incomeSource" id="income-sources-select" onChange={handleChange}>
                <option key="disabled-selected-income-sources" value="" disabled selected>--Please choose and option--</option>
                {generateOptions()}
            </select>
            incomeSource
            description
            preTaxAmount
            postTaxAmount
            timeOfCreation - use current time or past time
        </form>
     );
}
 
export default IncomeForm;