import Entry from "./Entry";
import YearEntry from "./YearEntry";

const SelectEntry = ({ listOfEntries, entryToEdit, checkForMoreDetails, setCheckForMoreDetails }) => {

    return (
        <main>
            {!listOfEntries ? <p>Page Loading...</p> : (!checkForMoreDetails ? <YearEntry listOfEntries={listOfEntries} setCheckForMoreDetails={setCheckForMoreDetails}/> : <Entry checkForMoreDetails={checkForMoreDetails}/>)}
        </main>
    );
}

export default SelectEntry;