"use client";
import BaseTextField from "@/components/inputs/TextField/BaseTextField/BaseTextField";
import TextField from "@/components/inputs/TextField/TextField";
import { useListPetsSuspense } from "@/generated/endpoints/petstore/petstore";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import { useEffect, useState } from "react";
import { Controller, useForm, useWatch } from "react-hook-form";

const Home = () => {
  const query = useListPetsSuspense();
  const { control } = useForm<{ test: string }>({
    defaultValues: {
      test: "default",
    },
  });

  const watch = useWatch({ control, name: "test" });

  const [a, setA] = useState(0);
  console.log("a", a);

  return (
    <div>
      {query.data.data.map((item) => {
        return <div key={item.id}>{item.name}</div>;
      })}

      <Button onClick={() => setA((prev) => prev + 1)}>Button</Button>
      <TextField control={control} name="test" />
      <BaseTextField
        fieldError={{
          message: "this is an error",
          type: "onChange",
        }}
      />
    </div>
  );
};

export default Home;
