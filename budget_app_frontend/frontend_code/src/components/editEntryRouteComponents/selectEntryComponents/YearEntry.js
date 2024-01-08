const YearEntry = ({listOfEntries, setCheckForMoreDetails}) => {
    
    const handleClick = (entry) => {
        setCheckForMoreDetails(entry);
    };

    const generateYearsElements = () => {
        return listOfEntries.map((entry) => {
            return <button key={entry.year} onClick={() => { handleClick(entry) }}>{entry.year}</button>
        });
    };

    return (
            <>
                <h2>Years</h2>
                {generateYearsElements()}
            </>
    );
};
 
export default YearEntry;