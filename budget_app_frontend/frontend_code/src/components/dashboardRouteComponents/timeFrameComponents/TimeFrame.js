import { useNavigate } from "react-router-dom";
import Month from "./Month";
import Year from "./Year";

const TimeFrame = ({listOfEntries, currentTimeFrame , setCurrentTimeFrame , setDashboardEntries}) => {

    const navigate = useNavigate();

    const handleDashboardSelection = (entries)=>{
        setDashboardEntries(entries);
        navigate("/dashboard");
    };

    return ( 
        <main>
            <p>This is the timeFrame</p>
            {!listOfEntries ? <p>Page Loading...</p> : (!currentTimeFrame ? <Year listOfEntries={listOfEntries} setCurrentTimeFrame={setCurrentTimeFrame} handleDashboardSelection={handleDashboardSelection}/> : <Month />)}
        </main>
     );
}
 
export default TimeFrame;