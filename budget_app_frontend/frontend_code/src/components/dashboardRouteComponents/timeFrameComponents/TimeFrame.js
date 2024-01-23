import Month from "./Month";
import Year from "./Year";

const TimeFrame = ({listOfEntries, currentTimeFrame , setCurrentTimeFrame , setDashboardEntries}) => {
    return ( 
        <main>
            <p>This is the timeFrame</p>
            {!listOfEntries ? <p>Page Loading...</p> : (!currentTimeFrame ? <Year listOfEntries={listOfEntries} setCurrentTimeFrame={setCurrentTimeFrame} setDashboardEntries={setDashboardEntries}/> : <Month />)}
        </main>
     );
}
 
export default TimeFrame;