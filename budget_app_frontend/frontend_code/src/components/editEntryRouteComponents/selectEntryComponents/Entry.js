const Entry = ({checkForMoreDetails}) => {
    const months = { 1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6: "June", 7: "July", 8: "August", 9: "September", 10: "October", 11: "November", 12: "December" }

    const generateEntryTypeWord = (entryType) => {
        return entryType.charAt(0) + entryType.substring(1).toLowerCase().split("_").join(" ");
    };

    const formatTimeOfCreation = (timeOfCreation) => {
        const sections = timeOfCreation.split("T")[0].split("-");
        return `${sections[2]}/${sections[1]}/${sections[0]}`;
    };

    const generateEntriesByMonth = (listOfEntries) => {
        return listOfEntries.map((entry) => {
            return <button key={entry.id}>{generateEntryTypeWord(entry.entryType)} - {formatTimeOfCreation(entry.timeOfCreation)}</button>
        });
    };

    const generateMoreDetailsElements = () => {
        return checkForMoreDetails.monthsList.map((month) => {
            return (
                <div key={month.month}>
                    <h3>{months[month.month]}</h3>
                    {(month.incomes.length > 0) ? generateEntriesByMonth(month.incomes) : null}
                    {(month.expenses.length > 0) ? generateEntriesByMonth(month.expenses) : null}
                    {(month.budgets.length > 0) ? generateEntriesByMonth(month.budgets) : null}
                    {(month.actualSavings.length > 0) ? generateEntriesByMonth(month.actualSavings) : null}
                    {(month.savingGoals.length > 0) ? generateEntriesByMonth(month.savingGoals) : null}
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