import { useNavigate } from "react-router-dom";

const Entry = ({ checkForMoreDetails, setEntryToEdit }) => {

    const navigate = useNavigate();

    const months = { 1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6: "June", 7: "July", 8: "August", 9: "September", 10: "October", 11: "November", 12: "December" }

    const generateEntryTypeWord = (entryType) => {
        return entryType.charAt(0) + entryType.substring(1).toLowerCase().split("_").join(" ");
    };

    const formatTimeOfCreation = (timeOfCreation) => {
        const sections = timeOfCreation.split("T");
        const dateSections = sections[0].split("-");
        const timeSections = sections[1].slice(0,5);
        return `${dateSections[2]}/${dateSections[1]}/${dateSections[0]} at ${timeSections}`;
    };

    const generateLastEdit = (timeOfLastEdit)=>{
        return timeOfLastEdit ? formatTimeOfCreation(timeOfLastEdit) : null;
    };

    const handleEntrySelection = (entry) => {
        setEntryToEdit(entry);
        navigate("/edit-entry");
    };

    const generateMonths = (listOfEntries) => {
        return listOfEntries.map((entry) => {
            return <button key={entry.id} onClick={() => { handleEntrySelection(entry) }}>{generateEntryTypeWord(entry.entryType)} Created on: {formatTimeOfCreation(entry.timeOfCreation)} Last edited on: {generateLastEdit(entry.timeOfLastEdit)}</button>
        });
    };

    const generateEntriesByMonth = (listOfEntries, entry) => {
        return (
            <>
                <h4>{entry}</h4>
                {generateMonths(listOfEntries)}
            </>
        );
    };

    const generateMoreDetailsElements = () => {
        return checkForMoreDetails.monthsList.map((month) => {
            return (
                <div key={month.month}>
                    <h3>{months[month.month]}</h3>
                    {(month.incomes.length > 0) ? generateEntriesByMonth(month.incomes, "Income(s) for this month:") : null}
                    {(month.expenses.length > 0) ? generateEntriesByMonth(month.expenses, "Expense(s) for this month:") : null}
                    {(month.budgets.length > 0) ? generateEntriesByMonth(month.budgets, "Budget(s) for this month:") : null}
                    {(month.actualSavings.length > 0) ? generateEntriesByMonth(month.actualSavings, "Actual Saving(s) for this month:") : null}
                    {(month.savingGoals.length > 0) ? generateEntriesByMonth(month.savingGoals, "Saving Goal(s) for this month:") : null}
                </div>
            )
        });
    }

    return (
        <>
            <h2 key={checkForMoreDetails.year}>{checkForMoreDetails.year}</h2>
            {generateMoreDetailsElements()}
        </>
    );
}

export default Entry;