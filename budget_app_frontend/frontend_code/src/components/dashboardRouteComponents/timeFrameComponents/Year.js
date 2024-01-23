import { useState } from "react";

const Year = ({listOfEntries, setCurrentTimeFrame, setDashboardEntries}) => {

    const [checkedState, setCheckedState] = useState([]);

    const handleChange = (index) => {
        let copiedState = [...checkedState ];
        copiedState[index] = !copiedState[index];

        setCheckedState(copiedState);
    };

    const generateYears = () => {
        return listOfEntries.map((entries, index) => {
            checkedState.push(false);
            return (
                <label key={index}>
                    {entries.year}
                    <input type="checkbox" checked={checkedState[index]} onChange={() => { handleChange(index) }} />
                </label>
            );
        });
    };

    return (
        <>
            {
                <form>
                    {generateYears()}
                </form>
            }
        </>
    );
}

export default Year;