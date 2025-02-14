import './App.css'
import { BarChart } from './BarChart'
const data = {
  US: {
    basicSalary: [125, 80, 40],
    benefitsTaxFees: [80, 50, 10],
  },
  EU: {
    basicSalary: [80, 60, 40],
    benefitsTaxFees: [35.44, 16, 10],
  },
};

function App() {
  return (
    <div className="flex flex-col h-screen justify-center items-center gap-8">
      <BarChart data={data["US"]}/>
    </div>
  )
}

export default App
