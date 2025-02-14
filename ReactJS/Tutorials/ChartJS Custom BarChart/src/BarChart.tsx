import React, {useState, useRef, useEffect} from "react";
import { Bar } from "react-chartjs-2";
import { Chart, BarElement, CategoryScale, LinearScale, Title, Tooltip, Legend } from "chart.js";
import ChartDataLabels from "chartjs-plugin-datalabels";

Chart.register(BarElement, CategoryScale, LinearScale, Title, Tooltip, Legend, ChartDataLabels);

interface BarChartProps {
  data: {
    basicSalary: number[];
    benefitsTaxFees: number[];
  };
}

export const BarChart: React.FC<BarChartProps> = ({ data }) => {
  const labels = ["USA", "Latin America", "TalentX"];
  const chartRef = useRef<any>(null);
  const [isMobile, setIsMobile] = useState(false);

  const basicSalaryData = data.basicSalary;
  const benefitsTaxFeesData = data.benefitsTaxFees;
  const totalValues = basicSalaryData.map((val, idx) => val + benefitsTaxFeesData[idx]);

  const chartData = {
    labels,
    datasets: [
      {
        label: "Basic Salary",
        data: basicSalaryData,
        backgroundColor: (context: any) => {
          const ctx = context.chart.ctx;
          const gradient = ctx.createLinearGradient(0, 0, 0, context.chart.height);
          gradient.addColorStop(0.0155, "#F9BC37");
          gradient.addColorStop(0.9845, "#F0C974");
          return gradient;
        },
        stack: "stack1",
        barThickness: isMobile ? 66 : 159,
        datalabels: {
          display: false,
        },
      },
      {
        label: "Benefits, Tax & Fees",
        data: benefitsTaxFeesData,
        backgroundColor: (context: any) => {
          const ctx = context.chart.ctx;
          const gradient = ctx.createLinearGradient(0, 0, 0, context.chart.height);
          gradient.addColorStop(0.0155, "#9E37F9");
          gradient.addColorStop(0.9845, "#B674F0");
          return gradient;
        },
        stack: "stack1",
        barThickness: isMobile ? 66 : 159,
        borderRadius: 16
      },
    ],
  };

  const options = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
     x: {
      stacked: true,
      ticks: {
        font: {
          size: 16,
          family: "sans-serif",
          weight: 'bold',
        }
      }, 
      grid:{
        display: false
      }
     },
     y: {
        min: 0,
        max: 250,
        stacked: true,
        beginAtZero: true,
        ticks: {
          stepSize: 50,
          font: {
            size: isMobile ? 14 : 18,
            family: "sans-serif",
            weight: 'normal',
          },
          callback: (value: number) => {
            return `$${(value * 1000).toLocaleString()}`;
          },
        },
     }
    },
    plugins: {
      legend: { 
        display: false 
      },
      tooltip :{
        enabled: true,
        callbacks: {
          label: (context: any) => {
            const label = context.dataset.label || '';
            const value = context.raw * 1000;
            return `${label}: $${value.toLocaleString()}`;
          }
        }
      },
      datalabels: {
        display: true,
        anchor: "end",
        align: "top",
        offset: 2,
        formatter: (value: any, context: any) => {
          const index = context.dataIndex;
          return `$${(totalValues[index] * 1000).toLocaleString()}`;
        },
        font: {
          size: isMobile ? 14 : 18,
          family: "sans-serif",
          weight: 'bold',
        },
      },
    },
  };

  useEffect(() => {
    const handleResize = () => {
      setIsMobile(window.innerWidth < 768);
    };

    window.addEventListener('resize', handleResize);
    handleResize();

    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);


  return (
    <div className="w-full max-w-4xl p-4 md:px-16">
      <div className="h-96">
        <Bar ref={chartRef} data={chartData} options={options as any}/>
      </div>
    </div>
  );
};
