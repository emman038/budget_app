import Entry from "./Entry";
import YearEntry from "./YearEntry";
import { useState } from "react";

const SelectEntry = ({ listOfEntries, entryToEdit }) => {

    const months = {1: "January", 2: "February", 3: "March", 4: "April", 5: "May", 6:"June", 7: "July", 8: "August", 9: "September", 10: "October", 11: "November", 12: "December"}

    const [checkForMoreDetails, setCheckForMoreDetails] = useState(null);

    const handleClick = (entry) => {
        setCheckForMoreDetails(entry);
    };

    const generateYearsElements = () => {
        return listOfEntries.map((entry) => {
            return <button key={entry.year} onClick={() => { handleClick(entry) }}>{entry.year}</button>
        });
    };

    const generateYears = () => {
        return (
            <>
                <h2>Years</h2>
                {generateYearsElements()}
            </>
        );
    };

    const generateMoreDetailsElements = ()=>{
        return checkForMoreDetails.monthsList.map((month)=>{
            return (
                <h3>{months[month.month]}</h3>
            )
            });
    }

    const generateMoreDetails = () => {
        return (
            <>
                <h2>{checkForMoreDetails.year}</h2>
                {generateMoreDetailsElements()}
            </>
        )
    };

    return (
        <main>
            {!listOfEntries ? <p>Page Loading...</p> : (!checkForMoreDetails ? generateYears() : generateMoreDetails())}
        </main>
    );
}

export default SelectEntry;