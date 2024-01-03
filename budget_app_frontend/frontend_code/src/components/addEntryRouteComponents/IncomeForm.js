const IncomeForm = ({listOfIncomeSources}) => {

    const generateOptions = ()=>{
        return listOfIncomeSources.map((incomeSource)=>{
            return <option  id={incomeSource.id} value={incomeSource}></option>
        });
    };

    return ( 
        <form>
            <label htmlFor="income-sources-select">Choose a source of income</label>
            <select name="income-sources" id="income-sources-select">
                <option value="" disabled selected hidden>--Please choose and option--</option>
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