import { useState } from "react";

const Year = ({ listOfEntries, setCurrentTimeFrame, handleDashboardSelection }) => {

    const [checkedStates, setCheckedStates] = useState([]);

    const handleChangeCheckbox = (index) => {
        let copiedStates = [...checkedStates];
        copiedStates[index] = !copiedStates[index];

        setCheckedStates(copiedStates);
    };

    const generateYears = () => {
        return listOfEntries.map((entry, index) => {
            checkedStates.push(false);

            return (
                <label key={index}>
                    {entry.year}
                    <input type="checkbox" checked={checkedStates[index]} onChange={() => { handleChangeCheckbox(index) }} />
                </label>
            );
        });
    };

    const handleDashboardClick = (event) => {
        event.preventDefault();

        const indexesOfCheckedEntries = checkedStates.map((checkedState, index)=>{
            return checkedState ? index: null;
        });

        const selectedEntries = listOfEntries.filter((entry, index)=>{
            return indexesOfCheckedEntries.includes(index) ? entry : null;
        });
        
        selectedEntries.length > 0 ? handleDashboardSelection(selectedEntries) : alert("please select some entries");
    };

    const handleSetCurrentTimeFrame = (event)=>{
        event.preventDefault();

        const indexesOfCheckedEntries = checkedStates.map((checkedState, index)=>{
            return checkedState ? index: null;
        });

        const selectedEntries = listOfEntries.filter((entry, index)=>{
            return indexesOfCheckedEntries.includes(index) ? entry : null;
        });
        
        selectedEntries.length > 0 ? setCurrentTimeFrame(selectedEntries) : alert("please select some entries");
    };

    return (
        <>
            {listOfEntries ?
                (
                    <form>
                        {generateYears()}

                        <button onClick={handleDashboardClick}>View dashboard with the selected year(s)</button>
                        <button onClick={handleSetCurrentTimeFrame}>View specific months of selected year(s)</button>
                    </form>
                ) :
                <h2>You have not created any entries yet. Please go back and create some.</h2>}
        </>
    );
}

export default Year;