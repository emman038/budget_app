import { useState } from "react";

const Month = ({ currentTimeFrame }) => {

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

    return (
        <>
            {generateElements}
        </>
    );
}

export default Month;