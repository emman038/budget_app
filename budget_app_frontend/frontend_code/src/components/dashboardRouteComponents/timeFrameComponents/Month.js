import { useState } from "react";

const Month = ({ currentTimeFrame, handleDashboardSelection }) => {

    const [checkedStates, setCheckedStates] = useState({});

    const handleChangeCheckbox = (propertyName) => {
        let copiedStates = { ...checkedStates };
        copiedStates[propertyName] = !copiedStates[propertyName];

        setCheckedStates(copiedStates);
    };

    const months = { 1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6: "June", 7: "July", 8: "August", 9: "September", 10: "October", 11: "November", 12: "December" }

    const generateMonths = (entry) => {
        return entry.monthsList.map((month) => {
            const propertyName = `${entry.year}-${month.month}`;

            return (
                <>
                    <label>
                        {months[month.month]}
                        <input type="checkbox" checked={checkedStates[propertyName] || false} onChange={() => { handleChangeCheckbox(propertyName) }} />
                    </label>
                </>
            )
        });
    };

    const generateElements = currentTimeFrame.map((entry) => {
        return (
            <div>
                <h2>{entry.year}</h2>
                {generateMonths(entry)}
            </div>
        );
    });

    const handleDashboardClick = (event) => {
        event.preventDefault();

        const checkedStateKeys = Object.keys(checkedStates);

        const checkedYears = [];

        for (let checkedState of checkedStateKeys) {
            checkedYears.push(checkedState.split("-")[0]);
        }

        const distinctYears = Array.from(new Set(checkedYears));

        const selectedEntries = currentTimeFrame.filter((entry) => {
            return distinctYears.includes(`${entry.year}`) ? entry : null;
        }).map((entry)=>{
            return {
                year: entry.year,
                monthsList: entry.monthsList.filter((month)=>{
                    return checkedStates[`${entry.year}-${month.month}`] ? month : null;
                })
            }
        });

        selectedEntries.length > 0 ? handleDashboardSelection(selectedEntries) : alert("Please select some entries");
    };

    return (
        <form>
            {generateElements}
            <button onClick={handleDashboardClick}>View dashboard with the selected information</button>
        </form>
    );
}

export default Month;